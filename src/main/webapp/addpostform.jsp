<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post" >
<table>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>UserId:</td><td><input type="text" name="userid"> </td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"> </td></tr>
<tr><td>Age:</td><td><input type="number" name="age"/></td></tr>
<tr><td>Job:</td><td><input type="text" name="job"/></td></tr>

    <tr><td>Habit:</td><td><input type="text" name="habit"/></td></tr>

    <tr><td>email:</td><td><input type="email" name="email"/></td></tr>

<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>