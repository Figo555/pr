<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wiadomość</title>
</head>
<body>
	<center><strong>
		${message}
		<p><a href="${path}/user/list/">User List</a></p>
		<p><a href="${path}/user/form">Add User</a></p>
		<p><a href="${path}/section/list/">Section List</a></p>
		<p><a href="${path}/section/form">Add Section</a></p>
	</strong></center>
</body>
</html>