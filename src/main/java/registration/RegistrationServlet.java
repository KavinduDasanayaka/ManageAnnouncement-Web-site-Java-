package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CacheResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		String upost = request.getParameter("post");
		
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");   //load Driver class
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup?useSSL=false","root","PHW#84#jeor");
			PreparedStatement stat = con.prepareStatement("insert into users(uname,upwd,uemail,umobile,post) values (?,?,?,?,?)");
			stat.setString(1, uname);
			stat.setString(2, upwd);
			stat.setString(3, uemail);
			stat.setString(4, umobile);
			stat.setString(5, upost);
			
			int rowCount = stat.executeUpdate();  //return number of row effected
			
			dispatcher = request.getRequestDispatcher("registration.jsp");
			
			if(rowCount > 0) {
				request.setAttribute("Status","Congrats! Account created");	
			}else {
				request.setAttribute("Status","Faild");    //send to input type hiddne
			}
			
			dispatcher.forward(request, response);  //pass this as a request
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 

		
	}

}
