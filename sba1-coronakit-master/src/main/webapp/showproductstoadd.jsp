<%@ page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@ page import="java.util.List"%>
<%@ page language="java" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>


<p>Select product to create Corona Kit.</p>
<%
		// fetch the shared data
		List<ProductMaster> productMasterList =  (List<ProductMaster>) request.getAttribute("productMasterList");
	%>
	
<table border="1" width="100%">
		<thead>
			<th>S.No</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Cost</th>
			<th></th>
		</thead>
		<tbody>
			<% for(ProductMaster productMaster : productMasterList) { %>
			<tr>
				<td><%=productMaster.getId()%></td>
				<td><%=productMaster.getProductName()%></td>
				<td><%=productMaster.getProductDescription()%></td>
				<td><%=productMaster.getCost()%></td>
				<td><a href="user?action=saveorder&id=<%=productMaster.getId()%>"><button>Add to Cart</button></a></td>
				
			</tr>
		<% } %>
		</tbody>
	</table>
	<a href="user?action=placeorder"><button>Place order</button></a>
	<br>
	<a href="user?action=showkit"><button>View Cart</button></a>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>