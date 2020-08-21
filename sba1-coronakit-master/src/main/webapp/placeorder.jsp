<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>



<form action="user?action=ordersummary" method="post">
	<div>
	
		<div><label>Address</label> <input type="text"   name="address"></div>
		<br/>
		<div> <input type="submit" value="Submit"> </div>
	</div>

</form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>