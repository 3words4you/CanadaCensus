<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="prog3060.g5.model.AreaDetail" %>

<% ArrayList<AreaDetail> subAreaList = (ArrayList<AreaDetail>) session.getAttribute("subAreaList"); %>
<% AreaDetail areaDetail = (AreaDetail) session.getAttribute("areaDetail"); %>
<% String classificationTitle = (String) session.getAttribute("classificationTitle"); %>
<% String subClassificationTitle = (String) session.getAttribute("subClassificationTitle"); %>

<%@include file="./Header.jsp" %>
<body>
	<div class="wrap">
		<div class="row">
			<div class="col-12" align="center"><h3><%= classificationTitle %></h3></div>
		</div>
		<table class="table">
	  		<thead class="thead-dark">
	    			<tr>
	      			<th scope="col">Code</th>
	      			<th scope="col">Level</th>
	      			<th scope="col">Name</th>
	      			<th scope="col">Alternative Code</th>
	      			<th scope="col">Population(2016)</th>
	    			</tr>
	  		</thead>
	  		<tbody>
		      	<tr>
			      	<td><%= areaDetail.getCode() %></td>
			      	<td><%= areaDetail.getLevel() %></td>
			      	<td><%= areaDetail.getName() %></td>
			      	<td><%= areaDetail.getAlternativeCode() %></td>
			      	<td><%= areaDetail.getTotalPopulation() %></td>
	    			</tr>  
	  		</tbody>
		</table>
		<div class="row">
			<div class="col-12" align="center"><h3><%= subClassificationTitle %></h3></div>
		</div>
		<div class="row">
    			<div class="col-12">
    				<div class="list-group">
				 
				    <% if(subAreaList.size()>0 ) {%>
					   	<% for(AreaDetail subAreaDetail : subAreaList ) { %>
					   		<% String url ="./AreaDetailServlet?alternativeCode="+ subAreaDetail.getAlternativeCode()+"&level="+subAreaDetail.getLevel()+"&code="+subAreaDetail.getCode(); %>
					      	<a class="list-group-item list-group-item-action" href=<%= url %>><%= subAreaDetail.getName() %></a>
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