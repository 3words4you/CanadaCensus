package prog3060.g5.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog3060.g5.db.DBManager;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			Connection tempConnection = DBManager.OpenConnection(username,password);

			response.sendRedirect("./Menu.jsp");
			
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();
	        String redirectUrl = "./Error.jsp";
	        
	        //incorrect userName or password
	        if(e.getErrorCode() == 40000) {
	        		redirectUrl = "./Login.jsp";
	        }
	        response.sendRedirect(redirectUrl);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("./Error.jsp");
	    }
	}
	

}
