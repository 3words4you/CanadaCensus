package prog3060.g5.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.g5.db.DBManager;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession tempSession = request.getSession();
		setIsMatchFlag(tempSession,true);
		response.sendRedirect("./Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession tempSession = request.getSession();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			Connection tempConnection = DBManager.OpenConnection(username,password);
			tempSession.setAttribute("conn", tempConnection);
			setIsMatchFlag(tempSession,true);
			response.sendRedirect("./Menu.jsp");
			
	    } catch (SQLException e) {
	        String redirectUrl = "./Error.jsp";
	        
	        //incorrect userName or password
	        if(e.getErrorCode() == 40000) {
	        		redirectUrl = "./Login.jsp";
	        		setIsMatchFlag(tempSession,false);
	        }
	        else {
	        		e.printStackTrace();
	        }
	        response.sendRedirect(redirectUrl);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("./Error.jsp");
	    }
	}
	
	//match flag for the username password
	public void setIsMatchFlag(HttpSession tempSession,Boolean flag) {	
		tempSession.setAttribute("match", flag);
	}
	

}
