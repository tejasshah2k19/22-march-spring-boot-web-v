<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Profile</title>
</head>
<body>

	<form action="saveprofile" method="post" enctype="multipart/form-data">

		FirstName: <input type="text" name="firstName"><br>
		<br> Email:<input type="text" name="email"><br>
		<br> Password:<input type="password" name="password"><br>
		<br> ProfilePic: <input type="file" name="profilePic"><br>
		<br> <input type="submit" value="Upload Profile">
	</form>

</body>
</html>