<%@ page import="com.iiht.evaluation.coronokit.model.KitDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<h1>Thank you for Choosing Corona Kit</h1>

<br>

<%
		// fetch the shared data
		List<KitDetail> kitCustList =  (List<KitDetail>) request.getAttribute("kitCustList");
	%>

<% for(KitDetail kitDetail1 : kitCustList) { %>

<h4>Name = <%=kitDetail1.getName() %></h4>
<h4>Email = <%=kitDetail1.getEmail() %></h4>
<h4>Contact = <%=kitDetail1.getContact() %></h4>
<% } %>
<% String address = session.getAttribute("address").toString(); %>
<h4>Address = <%=address %></h4>
<br>
<p>Details of your Order</p>

<%
		// fetch the shared data
		List<KitDetail> kitDetailList =  (List<KitDetail>) request.getAttribute("kitDetailList");
int total = 0;
	%>
	
	<table border="1" width="100%">
		<thead>
			<th>S.No</th>
			<th>Product Description</th>
			<th>Product Name</th>
			<th>Product Cost</th>
		</thead>
		<tbody>
			<% for(KitDetail kitDetail : kitDetailList) { %>
			<tr>
			<td><%=kitDetail.getCoronaKitId()%></td>
			<td><%=kitDetail.getDescription()%></td>
			<td><%=kitDetail.getname()%></td>
			<td><%=kitDetail.getAmount()%></td>
				</tr>
				<div><input type="hidden" value="<%=total = kitDetail.getAmount()+ total %>" name="id"></div>
			<% } %>
		
		</tbody>
	</table>
		<h3>Total = <%=total %></h3>
		<br>





<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>