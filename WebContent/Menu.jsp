<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<style>
		.wrap{
		    margin-top: 150px;
		    margin-left: auto;
		    margin-right: auto;
		    width: 80%;
		}
	</style>
</head>
<body>
	<div class="wrap">
	  <div class="row">
		<div class="col-sm-4">
    			<div class="card">
      			<div class="card-body">
        				<h5 class="card-title">Level 0</h5>
        				<p class="card-text">The country of Canada</p>
        				<a href="./AreaServlet?level=0" class="btn btn-primary">Get List</a>
      			</div>
    			</div>
  		</div>
 		<div class="col-sm-4">
    			<div class="card">
      			<div class="card-body">
        				<h5 class="card-title">Level 1</h5>
        				<p class="card-text">Provinces and Territories</p>
        				<a href="#" class="btn btn-primary">Get List</a>
      			</div>
    			</div>
  		</div>
  		<div class="col-sm-4">
    			<div class="card">
      			<div class="card-body">
        				<h5 class="card-title">Level 3</h5>
        				<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        				<a href="#" class="btn btn-primary">Get List</a>
      			</div>
    			</div>
  		</div>
	  </div>
	</div>     	
</body>
</html>