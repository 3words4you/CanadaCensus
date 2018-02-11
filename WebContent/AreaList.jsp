<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="prog3060.g5.model.AreaDetail" %>

<% ArrayList<AreaDetail> areaList = (ArrayList<AreaDetail>) session.getAttribute("areaList"); %>
<% String title = (String) session.getAttribute("title"); %>

<%@include file="./Header.jsp" %>
<body>
	<div class="wrap">
		<div class="row">
			<div class="col-12" align="center"><h3><%= title %></h3></div>
		</div>
		<div class="row">
    			<div class="col-12">
    				<div class="list-group">
				 
				    <% if(areaList  != null) {%>
					   	<% for(AreaDetail areaDetail : areaList ) { %>
					   		<% String url ="./AreaDetailServlet?alternativeCode="+ areaDetail.getAlternativeCode()+"&level="+areaDetail.getLevel()+"&code="+areaDetail.getCode(); %>
					      	<a class="list-group-item list-group-item-action" href=<%= url %>><%= areaDetail.getName() %></a>
					   	<% } %>
					<% }else{ %>
					  	<p>No record</p>
					<% } %>
					
    				</div>
  			</div>
	  	</div>
	  	<br>
	</div>
</body>
</html>