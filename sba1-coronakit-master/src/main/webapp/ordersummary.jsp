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
String pname = (String) session.getAttribute("pname");
%>
<h3>Name =  <%= pname %></h3>
<%
String pemail = (String) session.getAttribute("pemail");
%>
<h3>Email = <%= pemail %></h3>
<%
String pcontact = (String) session.getAttribute("pcontact");
%>
<h3>Contact = <%= pcontact %></h3>
<% String address = session.getAttribute("address").toString(); %>
<h3>Address = <%=address %></h3>
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