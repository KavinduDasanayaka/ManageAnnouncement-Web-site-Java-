package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname =  request.getParameter("username");
		String upwd =  request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");   //load Driver class
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup?useSSL=false","root","PHW#84#jeor");
			PreparedStatement stat = con.prepareStatement("select * from users where uname = ? and upwd = ?");
			stat.setString(1, uname);
			stat.setString(2, upwd);
			
			 ResultSet set = stat.executeQuery();  //Select query execute   // return result set
			 
			 if(set.next()) {
				 session.setAttribute("name", set.getString("uname"));
				 dispatcher = request.getRequestDispatcher("index.jsp");
			 }
			 else {
				 request.setAttribute("Status", "Sorry!Login faild");
				 dispatcher = request.getRequestDispatcher("login.jsp");
			 }
			 dispatcher.forward(request, response);  //forward request 
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
