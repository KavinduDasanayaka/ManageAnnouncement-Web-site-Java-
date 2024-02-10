package announceDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import announceModel.announce;

//This DAO class provides CRUD database operations for the table users in the database
public class announceDAO {  //Data access  object
	private  String jdbcURL = "jdbc:mysql://localhost:3306/annnounce?useSSL = false";
	private  String jdbcUsername = "root";
	private  String jdbcPassword = "PHW#84#jeor";
	
	//Insert sql query
	private static final String INSERT_ANNOUNCE_SQL = "INSERT INTO announce" + "(name, announce,grade,date,subject) values"
	        + "(?,?,?,?,?);";
	
	//Select sql query
	private static final String SELECT_ANNOUNCE_BY_ID = "SELECT id,name,announce,grade,date,subject from announce where id = ?;";

	private static final String SELECT_ALL_ANNOUNCE = "SELECT * FROM announce;";
	
	//Delete sql query
	private static final String DELETE_ANNOUNCE_SQL = "DELETE FROM announce where id = ?;";
	
	//update sql query
	private static final String UPDATE_ANNOUNCE_SQL = "UPDATE announce SET name = ?,announce = ?,grade = ?,date = ?,subject = ? where id = ?;";
	
	protected Connection getConnection () {   //Method for create connection with the database
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return  connection;
			
	}
	
	//insert announcement
	
	public void insertAnnounce(announce announce) throws SQLException {
		try(Connection connection = getConnection();
			    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANNOUNCE_SQL)){
			preparedStatement.setString(1, announce.getName());        //set values  to the query
			preparedStatement.setString(2,announce.getAnnounce());
			preparedStatement.setString(3, announce.getGrade());
			preparedStatement.setString(4, announce.getDate());
			preparedStatement.setString(5, announce.getSubject());
         
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update announcement
	
	public boolean updateAnnounce(announce announce) throws SQLException{
		boolean updateRow;
		try(Connection connection = getConnection();
			    PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ANNOUNCE_SQL);){
			preparedStatement.setString(1,announce.getName());           //set Values to the query
			preparedStatement.setString(2, announce.getAnnounce());
			preparedStatement.setString(3, announce.getGrade());
			preparedStatement.setString(4, announce.getDate());
			preparedStatement.setString(5, announce.getSubject());
			preparedStatement.setInt(6, announce.getId());


            
			updateRow = preparedStatement.executeUpdate() > 0;  //return number of row effected
			
		}
		
		return updateRow;
		
	}
	
	//select user by id
	
	public announce selectAnnounce(int id) {
		announce announce = null;
		//Establishing a connection
		try(Connection connection = getConnection();
				//create a statement using connection object
			    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANNOUNCE_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println("preparedStatement");
			//Execute query or update query
			ResultSet result = preparedStatement.executeQuery(); //return resultset
			
			//Process the ResultSet Object
			while(result.next()) {
				String name = result.getString("name");
				String announce_A = result.getString("announce");
				String grade = result.getString("grade");
				String date = result.getString("date");
				String subject = result.getString("subject");

				announce = new announce(id,name,announce_A,grade,date,subject); //create a object of announce class with got data
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return announce; //return object
	}
	
	
	
	
	//select users
	
	public List<announce> selectAllAnnounce() {  //return array list of announce objects 
		List<announce> announce = new ArrayList<>(); 
		//Establishing a connection
		try(Connection connection = getConnection();
				//create a statement using connection object
			    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ANNOUNCE);){
			System.out.println("preparedStatement");
			//Execute query or update query
			ResultSet result = preparedStatement.executeQuery(); //return resultset
			
			//Process the ResultSet Object
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String announce_A = result.getString("announce");
				String grade = result.getString("grade");
				String date = result.getString("date");
				String subject = result.getString("subject");

				announce.add(new announce(id,name,announce_A,grade,date,subject)); //add announce object to array list
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}
		return announce; //return object
	}
	
	
	
	//delete users
	
	public boolean deleteAnnounce(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection connection = getConnection();
			    PreparedStatement statement = connection.prepareStatement(DELETE_ANNOUNCE_SQL);){
			statement.setInt(1,id);
			rowDeleted = statement.executeUpdate() > 0;  //return number of rows deleted
		}
		return rowDeleted;
	}
	
	

}
