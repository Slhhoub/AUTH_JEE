package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
	        String login = request.getParameter("login");
	        String psw = request.getParameter("password");

	        String url = "jdbc:mysql://localhost:3306/jee_etudiant";
	        String user = "root";
	        String pwd = "";

	        Connection con = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pwd);
	            if(con != null) {
	            	System.out.println("success connection db ");
	            	pst = con.prepareStatement("SELECT * FROM users WHERE login=? AND password=?");
	            	pst.setString(1, login);
	            	pst.setString(2, psw);
	            	rs=pst.executeQuery();
	            	if(rs.next()) {
	            		session.setAttribute("login", login);
	            	
	            		response.sendRedirect("home.jsp");
	            	}else {
	            		request.setAttribute("errorMessage", "username or password not found");
	            		
	            		request.getRequestDispatcher("login.jsp").forward(request, response);
	            	   
	            		response.sendRedirect("login.jsp");
	            	}
	            }else {
	            	System.out.println("error connection db ");   
	            	response.sendRedirect("login.jsp");
	            }    
	        } catch (Exception e) {
	            // Handle exceptions gracefully
	            System.out.println("Error: " + e);
	            response.sendRedirect("login.jsp"); // Redirect to an error page
	        } 

	}

}
