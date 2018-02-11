<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="prog3060.g5.model.AgeGroupDetail" %>

<% ArrayList<AgeGroupDetail> ageGroupList = (ArrayList<AgeGroupDetail>) session.getAttribute("ageGroupList"); %>

<%@include file="./Header.jsp" %>
<body>
	<div class="wrap">
		<div class="row">
			<div class="col-12" align="center"><h3>Age Groups</h3></div>
		</div>
		<table class="table">
	  		<thead class="thead-dark">
	    			<tr>
	      			<th scope="col">Description</th>
	      			<th scope="col">Male(2011)</th>
	      			<th scope="col">Female(2011)</th>
	      			<th scope="col">Male(2016)</th>
	      			<th scope="col">Female(2016)</th>
	    			</tr>
	  		</thead>
	  		<tbody>
	  			<% if(ageGroupList.size()>0 ) {%>
				   	<% for(AgeGroupDetail ageGroupDetail : ageGroupList ) { %>
				   		<tr>
					      	<td><%= ageGroupDetail.getDescription() %></td>
					      	<td><%= ageGroupDetail.getMalePopulationOld() %></td>
					      	<td><%= ageGroupDetail.getFemalePopulationOld() %></td>
					      	<td><%= ageGroupDetail.getMalePopulationNew() %></td>
					      	<td><%= ageGroupDetail.getFemalePopulationNew() %></td>
			    			</tr>  
				   	<% } %>
				<% }else{ %>
				  	
				<% } %>
		      	
	  		</tbody>
		</table>
		<br>
	</div>
	
</body>
</html>