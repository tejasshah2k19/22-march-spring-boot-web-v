<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h2>List Roles</h2>

	<table border="1">
		<tr>
			<th>RoleId</th>
			<th>RoleName</th>
		</tr>
		<c:forEach items="${roles}" var="r">
			<tr>
				<td>${r.roleId }</td>
				<td>${r.roleName}</td>
			</tr>
		</c:forEach>
	</table>





</body>
</html>