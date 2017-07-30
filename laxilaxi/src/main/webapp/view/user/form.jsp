<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User</title>
</head>
<body>
	<center><strong>
		<form:form method="post" action="${path}/user/add" commandName="userForm">
			<form:hidden path="id"/>
			<p>Login : <form:input path="userName" placeholder="Enter User Name"/></p>
			<p>Passowrd : <form:password path="password" placeholder="Enter Password"/></p>	
			<p>Name : <form:input path="firstName" placeholder="Enter First Name"/></p>
			<p>Second Name : <form:input path="lastName" placeholder="Enter Second Name"/></p>
			<p>date : <form:input path="date" placeholder="Enter Second Name"/></p>
			<p>
				Section :
				<form:select path="section.id">
					<c:forEach items="${sections}" var="section">
						<form:option value="${section.id}">${section.sectionId}</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				Role :
					<form:select path="role.id">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role.id}">${role.name}</form:option>
						</c:forEach>
					</form:select>
			</p>
			<p>
				<form:button value="Save">Save</form:button>
				<a href="${path}">Homepage</a>
			</p>
		</form:form>
	</strong></center>
</body>
</html>