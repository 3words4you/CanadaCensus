<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Boolean match = (Boolean) session.getAttribute("match"); %>
<%@include file="./Header.jsp" %>
<body>
	<div class="wrap" align="center">
		<h3>Canada Census</h3>
		<% if(!match) { %>
			<p style="color:red">It seems like you forgot your password :(</p>
		<% } %>
		<br>
		<form method="POST" action="./LoginServlet">
  			<div class="form-group row justify-content-center">
			    <div class="col-sm-3">
			      <input type="text" class="form-control" name="username" placeholder="Username">
			    </div>
  			</div>
  			<div class="form-group row justify-content-center">
			    <div class="col-sm-3">
			      <input type="password" class="form-control" name="password" placeholder="Password">
			    </div>
  			</div>
 			 <div class="form-group row justify-content-center">
			    <div class="col-sm-12">
			      <button type="submit" class="btn btn-primary">Sign in</button>
			    </div>
  			</div>
		</form>
	</div>
</body>
</html>