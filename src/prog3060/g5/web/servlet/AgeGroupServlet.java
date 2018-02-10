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

import prog3060.g5.model.AgeGroupDetail;
import prog3060.g5.db.DBManager;

@WebServlet("/AgeGroupServlet")
public class AgeGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession tempSession = request.getSession(); 
		//check authorization
		if(tempSession.getAttribute("conn") == null) {
			response.sendRedirect("./Login.jsp");
		}
		else {
			try {
				ResultSet ageGroupListRes = DBManager.GetAgeGroupList();
				
				ArrayList<AgeGroupDetail> ageGroupList = new ArrayList<AgeGroupDetail>();
				
				while(ageGroupListRes.next()) {
					//get 2016 detail
					String tempDescription = ageGroupListRes.getString("description");
					int tempAgeGroupID = ageGroupListRes.getInt("ageGroupID");
					//id 2 is year 2011
					//id 1 is year 2016
					ResultSet ageGroupDetailOldRes = DBManager.GetAgeGroupDetail(tempAgeGroupID,2);
					ResultSet ageGroupDetailNewRes = DBManager.GetAgeGroupDetail(tempAgeGroupID,1);
					
					int tempNumOfMaleOld = 0;
					int tempNumOfFemaleOld = 0;
					int tempNumOfMaleNew = 0;
					int tempNumOfFemaleNew = 0 ;
					while(ageGroupDetailOldRes.next()) {
						tempNumOfMaleOld= ageGroupDetailOldRes.getInt("totalMale");
						tempNumOfFemaleOld = ageGroupDetailOldRes.getInt("totalFemale");
					}
					while(ageGroupDetailNewRes.next()) {
						tempNumOfMaleNew = ageGroupDetailNewRes.getInt("totalMale");
						tempNumOfFemaleNew = ageGroupDetailNewRes.getInt("totalFemale");
					}
					AgeGroupDetail tempAgeGroupDetail = new AgeGroupDetail();
					
					tempAgeGroupDetail.setDescription(tempDescription);
					tempAgeGroupDetail.setMalePopulationOld(tempNumOfMaleOld);
					tempAgeGroupDetail.setMalePopulationNew(tempNumOfMaleNew);
					tempAgeGroupDetail.setFemalePopulationOld(tempNumOfFemaleOld);
					tempAgeGroupDetail.setFemalePopulationNew(tempNumOfFemaleNew);
					
					ageGroupList.add(tempAgeGroupDetail);
				}
				
		        String url = "./AgeGroupList.jsp" ;
		        tempSession.setAttribute("ageGroupList", ageGroupList);
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

}
