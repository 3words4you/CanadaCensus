<%@include file="./Header.jsp" %>
<body>
	<div class="wrap">
		<div class="row">
			<div class="col-12" align="center"><h3>Menu</h3></div>
		</div>
		<div class="row">
    			<div class="col-12">
    				<div class="list-group">
				    <a class="list-group-item list-group-item-action" href="./AreaServlet?level=0">The Country Of Canada</a>
				    <a class="list-group-item list-group-item-action" href="./AreaServlet?level=1">Provinces and Territories</a>
				    <a class="list-group-item list-group-item-action" href="./AreaServlet?level=2">Census metropolitan areas (CMA) and census agglomerations (CA</a>
				    <a class="list-group-item list-group-item-action" href="./AreaServlet?level=3">One CMA and three CAs are divided between adjacent provinces.  A valueequal to 3 signi es that this unit is one provincial part of a larger area</a>
    					<br>
    					<a class="list-group-item list-group-item-action" href="./AgeGroupServlet">Age Group</a>	
   				</div>
  			</div>
	  	</div>
	</div>     	
</body>
</html>