<%@ page import="com.iiht.evaluation.coronokit.model.KitDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-My Kit(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<%
		// fetch the shared data
		List<KitDetail> kitDetailList =  (List<KitDetail>) request.getAttribute("kitDetailList");
int total = 0;
	%>
	
	<table border="1" width="100%">
		<thead>
		<th>S.No</th>
		<th>Product Name</th>
			<th>Product Cost</th>
		</thead>
		<tbody>
			<% for(KitDetail kitDetail : kitDetailList) { %>
			<tr>
			<td><%=kitDetail.getCoronaKitId()%></td>
			<td><%=kitDetail.getname()%></td>
				<td><%=kitDetail.getAmount()%></td>
				</tr>
				<div><input type="hidden" value="<%=total = kitDetail.getAmount()+ total %>" name="id"></div>
			<% } %>
		
		</tbody>
	</table>
		<h3>Total = <%=total %></h3>
		<br>
	<a href="user?action=addnewitem"><button>View List</button></a>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>