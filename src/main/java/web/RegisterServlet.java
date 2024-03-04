package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/jee_etudiant";
        String user = "root";
        String pwd = "";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection  con = DriverManager.getConnection(url, user, pwd);
            if(con != null) {
	            PreparedStatement	pst= con.prepareStatement("SELECT login FROM users WHERE login = ?");
	            pst.setString(1, login);
	            ResultSet rs=pst.executeQuery();
	            if(rs.next()) {
	            	System.out.println("deja exit user");	
	            }else {
	            	System.out.println(" user");	           
	            }
            }
        }catch(Exception e){
        	System.out.println(e);
        }
		
	}

}
