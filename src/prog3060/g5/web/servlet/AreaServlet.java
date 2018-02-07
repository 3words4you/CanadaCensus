package prog3060.g5.web.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog3060.g5.db.DBManager;

@WebServlet("/AreaServlet")
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int level = Integer.parseInt(request.getParameter("level"));
			
			ResultSet res = DBManager.GetAreaListByLevel(0);
			//display result
	    		System.out.println("******************************************************************************************");
	        while (res.next())
	        {
	            String tempDescription = res.getString("name"); 
	            System.out.println(tempDescription);
	            
	        }
	        System.out.println("******************************************************************************************");
	        
	        String url;
	        switch (level) {
            case 0:  url = "./Country.jsp";
                     break;
            default: url = "./Menu.jsp";
                     break;
	        }
	        response.sendRedirect(url);
	        
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("./Error.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("./Error.jsp");
		}
		
	}

	

}
