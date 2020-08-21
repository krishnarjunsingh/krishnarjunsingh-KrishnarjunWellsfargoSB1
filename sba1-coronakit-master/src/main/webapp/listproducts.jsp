<%@ page import="com.iiht.evaluation.coronokit.model.ProductMaster"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(Admin)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<a href="admin?action=logout"><button>Log Out</button></a>
<br>
<br>
<a href="admin?action=newproduct"><button>Add New Product</button></a>

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
			<th></th>
		</thead>
		<tbody>
			<% for(ProductMaster productMaster : productMasterList) { %>
			<tr>
				<td><%=productMaster.getId()%></td>
				<td><%=productMaster.getProductName()%></td>
				<td><%=productMaster.getProductDescription()%></td>
				<td><%=productMaster.getCost()%></td>
				<td><a href="admin?action=editproduct&id=<%=productMaster.getId()%>"><button>Edit</button></a></td>
				<td><a href="admin?action=deleteproduct&id=<%=productMaster.getId()%>"><button>Delete</button></a></td>
			</tr>
		<% } %>
		</tbody>
	</table>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>