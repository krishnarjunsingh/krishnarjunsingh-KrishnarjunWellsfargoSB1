<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<form action="user?action=insertuser" method="post">
	<div>
	
		<div><label>Name</label> <input type="text"   name="pname"></div>
		<br/>
		<div><label>email</label> <input type="text" name="pemail"></div>
		<br/>
		<div><label>Contact No.</label> <input type="text" name="pcontact"></div>
		<br/>
		<div> <input type="submit" value="Add"> </div>
	</div>

</form>

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>