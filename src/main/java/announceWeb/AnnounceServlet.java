package announceWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import announceDAO.announceDAO;
import announceModel.announce;


/**
 * Servlet implementation class AnnounceServlet
 */
@WebServlet("/")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private announceDAO announceDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceServlet() {      //create DAO object inside default constructor
    	this.announceDAO = new announceDAO();

    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		this.doGet(request, response);  //call doGet method
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get action from the form
		String action = request.getServletPath();
		
		//Try catch block
		switch(action) {
		//to get new web request
		case "/new":
			showNewForm(request,response); //pass objects
			break;
		case "/insert":
			try {
				insertAnnounce(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteAnnounce(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
		case "/update":
			try {
				updateAnnounce(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		default:
			//handle list
			try {
				listAnnounce(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}

	}
    
	//TeacherList Form
	private void listAnnounce(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		
		List<announce> listA = announceDAO.selectAllAnnounce();
		request.setAttribute("listAnnouncement", listA);      
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherListForm.jsp");
		dispatcher.forward(request, response);	
		
	}
	
	
	private void updateAnnounce(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));          //Set Parameters
		String name = request.getParameter("name");
		String announce = request.getParameter("announce");
		String grade = request.getParameter("grade");
		String date = request.getParameter("date");
		String subject = request.getParameter("subject");
	
		
		announce announce1 = new announce(id,name,announce,grade,date,subject);
		announceDAO.updateAnnounce(announce1);
		response.sendRedirect("list");
		
		
	}
	
	
	
	
	
	
	private void deleteAnnounce(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		announceDAO.deleteAnnounce(id);
		response.sendRedirect("list");
		
		
	}
	
	//load data to edit form to update
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));
		announce existingAnnounce = announceDAO.selectAnnounce(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		request.setAttribute("Announce",existingAnnounce);    //set Announce  existingAnnounce
		dispatcher.forward(request, response);

		
		
		
	}	
	
	
	
	//forward to teacherform jsp
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
          
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		dispatcher.forward(request, response);
  
	}
	
	private void insertAnnounce(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		
		String name = request.getParameter("name");
		String announce = request.getParameter("announce");
		String grade = request.getParameter("grade");
		String date = request.getParameter("date");
		String subject = request.getParameter("subject");

		announce newAnnounce = new announce(name,announce,grade,date,subject);//announce object call newAnnounce
		announceDAO.insertAnnounce(newAnnounce);     //call insertUser method of announceDAO Object
		response.sendRedirect("list");   //redirect to list request(in default section of the switch)
		
		
		
		
	}

	

}
