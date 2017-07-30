<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User List</title>
</head>
<body>
	<center><strong>
		<table border=3>
			<thead>
				<tr>
					<th>User : </th>
					<th>Password :</th>
					<th>First Name :</th>
					<th>Last Name :</th>
					<th>Date Birthday : </th>
					<th>Role : </th>
					<th>Group : </th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">			
				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.date}</td>
					<td>${user.role.name}</td>
					<td>${user.section.sectionId}</td>
					<td><a href="${path}/user/edit/${user.id}">Edit</a>
					<td><a href="${path}/user/delete/${user.id}">Delete</a>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p><a href="${path}">DOM</a></p>
	</strong></center>
</body>
</html>