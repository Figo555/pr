<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Section List</title>
</head>
<body>
	<center><strong>
		<table border=1>
			<thead>
				<tr>
					<th>Group Name : </th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sections}" var="section">
				
				<tr>
					<td>${section.sectionId}</td>
					<td><a href="${path}/section/edit/${section.id}">Edit</a>
					<td><a href="${path}/section/delete/${section.id}">Delete</a>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="${path}">DOM</a></p>
	</strong></center>
</body>
</html>