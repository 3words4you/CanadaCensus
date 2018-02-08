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
	</div>
	<%-- <table class="table">
  		<thead class="thead-dark">
    			<tr>
      			<th scope="col">Code</th>
      			<th scope="col">Level</th>
      			<th scope="col">Name</th>
      			<th scope="col">Alternative Code</th>
    			</tr>
  		</thead>
  		<tbody>
  			<% if(areaList  != null) {%>
			   	<% for(AreaDetail araeDetail : areaList ) { %>
			      	<tr>
				      	<td><%= araeDetail.getCode() %></td>
				      	<td><%= araeDetail.getLevel() %></td>
				      	<td><%= araeDetail.getName() %></td>
				      	<td><%= araeDetail.getAlternativeCode() %></td>
		    			</tr>
			   	<% } %>
			<% }else{ %>
			  	<tr>
			  		<td>No Record</td>
			  	</tr>
			<% } %>
  		</tbody>
	</table> --%>
</body>
</html>