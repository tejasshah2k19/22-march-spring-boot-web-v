<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h2>All Images</h2>

	<table border="1">
		<tr>
			<td>File</td>
			<td>Action</td>
		</tr>


		<c:forEach items="${allFiles}" var="i">
			<tr>

				<tD><img src="${i}" height="100px" width="100px" /></tD>
				<tD><a href="viewimg?imgName=${i}">${i}</a></tD>
			</tr>
		</c:forEach>

	</table>

</body>
</html>