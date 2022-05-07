<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>

	<s:form action="saveuser" method="post" modelAttribute="user">
		FirstName : 
			<s:input path="firstName" />
		<s:errors path="firstName"></s:errors>
		<br>
		<br>
		Email:	<s:input path="email" />
		<s:errors path="email"></s:errors>
		<br>
		<br>
		Password:	<s:password path="password" />
		<s:errors path="password"></s:errors>
		<br>
		<br>
		<input type="submit" value="SaveUser">
	</s:form>



	<%-- <form action="saveuser" method="post">
		FirstName : <input type="text" name="firstName" /><br>
		<Br> Email :<input type="text" name="email" /><br>
		<Br> Password : <input type="text" name="password" /><br>
		<Br> <input type="submit" value="Signup">
	</form> --%>

</body>
</html>