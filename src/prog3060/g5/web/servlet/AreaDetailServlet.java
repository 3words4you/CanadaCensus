package prog3060.g5.web.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.g5.db.DBManager;
import prog3060.g5.model.AreaDetail;

@WebServlet("/AreaDetailServlet")
public class AreaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int alternativeCode = request.getParameter("alternativeCode").isEmpty() ? -1 : Integer.parseInt(request.getParameter("alternativeCode"));
			int level = Integer.parseInt(request.getParameter("level"));
			int code = request.getParameter("code").isEmpty() ? -1 : Integer.parseInt(request.getParameter("code"));
			
			int nextLevel = level + 1;
			
			//get area detail
			ResultSet res = DBManager.GetAreaDetailByAlternativeCode(alternativeCode);
			AreaDetail areaDetail = new AreaDetail();
			String currentName = "";
	        while (res.next())
	        {
	            int tempCode = res.getInt("code"); 
	            int tempLevel = res.getInt("level"); 
	            String tempName = res.getString("name");
	            currentName = tempName;
	            int tempAlternativeCode = res.getInt("alternativeCode"); 
	            
	            areaDetail.setCode(tempCode);
	            areaDetail.setLevel(tempLevel);
	            areaDetail.setName(tempName);
	            areaDetail.setAlternativeCode(tempAlternativeCode); 
	        }
	        
	        //get subAreaList
	        ResultSet subRes = DBManager.GetAreaListByLevel(nextLevel,code,alternativeCode);
			ArrayList<AreaDetail> subAreaList = new ArrayList<AreaDetail>();
	        while (subRes.next())
	        {
	            int tempCode = subRes.getInt("code"); 
	            int tempLevel = subRes.getInt("level"); 
	            String tempName = subRes.getString("name");
	            int tempAlternativeCode = subRes.getInt("alternativeCode"); 
	            
	            AreaDetail subAreaDetail = new AreaDetail();
	            subAreaDetail.setCode(tempCode);
	            subAreaDetail.setLevel(tempLevel);
	            subAreaDetail.setName(tempName);
	            subAreaDetail.setAlternativeCode(tempAlternativeCode);
	            
	            subAreaList.add(subAreaDetail);
	        }
	        
	        HttpSession tempSession = request.getSession(); 
	        String url = "./AreaDetail.jsp" ;
	        String classificationTitle = "";
	        String subClassificationTitle = "";
	        switch (level) {
            		case 0:	classificationTitle = "Country Detail";
            		subClassificationTitle = "Province List for "+currentName;
            				break;
            		case 1:	classificationTitle = "Province Detail";
            				subClassificationTitle = "City List for "+currentName;
    						break;
            		case 2:	classificationTitle = "City Detail";
            				subClassificationTitle = "Part List for "+currentName;
    						break;
            		default: classificationTitle = "Part Detail";
            				 subClassificationTitle = "No Others";
                     	 break;
	        }
	        
	        tempSession.setAttribute("classificationTitle", classificationTitle);
	        tempSession.setAttribute("subClassificationTitle", subClassificationTitle);
	        tempSession.setAttribute("areaDetail", areaDetail);
	        tempSession.setAttribute("subAreaList", subAreaList);
	        
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
