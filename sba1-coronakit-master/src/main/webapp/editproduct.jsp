<%@ page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Edit Product(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<%
		// fetch the shared data
		List<ProductMaster> productMasterList =  (List<ProductMaster>) request.getAttribute("productMasterList");
	%>
	<% for(ProductMaster productMaster : productMasterList) { %>
<form action="admin?action=updateproduct" method="post">

	<div>
			<div><input type="hidden" value="<%=productMaster.getId()%>" name="id"></div>
		<div><label>Product Name</label> <input type="text" value="<%=productMaster.getProductName()%>" name="pname"></div>
		<br/>
		<div><label>Product Cost</label> <input type="text" value="<%=productMaster.getCost()%>" name="pcost"></div>
		<br/>
		<div><label>Product Description</label> <input type="text" value="<%=productMaster.getProductDescription()%>" name="pdesc"></div>
		<br/>
		<div> <input type="submit" value="Update"> </div>
	</div>
	<% } %>
</form>


<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>