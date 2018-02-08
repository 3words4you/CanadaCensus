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

import prog3060.g5.bean.AreaListBean;
import prog3060.g5.db.DBManager;
import prog3060.g5.model.AreaDetail;

@WebServlet("/AreaServlet")
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int level = Integer.parseInt(request.getParameter("level"));
			
			ResultSet res = DBManager.GetAreaListByLevel(level);

			ArrayList<AreaDetail> areaList = new ArrayList<AreaDetail>();
	        while (res.next())
	        {
	            int tempCode = res.getInt("code"); 
	            int tempLevel = res.getInt("level"); 
	            String tempName = res.getString("name");
	            int tempAlternativeCode = res.getInt("alternativeCode"); 
	            
	            AreaDetail areaDetail = new AreaDetail();
	            areaDetail.setCode(tempCode);
	            areaDetail.setLevel(tempLevel);
	            areaDetail.setName(tempName);
	            areaDetail.setAlternativeCode(tempAlternativeCode);
	            
	            areaList.add(areaDetail);
	        }
	        
	        String url;
	        switch (level) {
            case 0:  url = "./Country.jsp";
                     break;
            default: url = "./Menu.jsp";
                     break;
	        }
	        
	        HttpSession tempSession = request.getSession(); 
	        tempSession.setAttribute("areaList", areaList);
	        AreaListBean tempBean = new AreaListBean();
	        tempBean.setAreaList(areaList);
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
