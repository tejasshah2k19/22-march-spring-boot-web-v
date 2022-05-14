<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error {
	color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>New Role</title>
</head>
<body>

	<s:form modelAttribute="role" method="post" action="saverole">
		RoleName : <s:input path="roleName" />
		<s:errors path="roleName" cssClass="error"></s:errors>
		<br>
		<br>
		<input type="submit" value="Save Role">

	</s:form>

</body>
</html>