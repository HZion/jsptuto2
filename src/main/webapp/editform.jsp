<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.example.dao.BoardDAO" %>
<%@ page import="com.example.bean.BoardVO" %>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
	<tr><td>Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
	<tr><td>UserID:</td><td> <%= u.getUserid()%></td></tr>
	<tr><td>Password:</td><td><input type="password" name ="password" value="<%= u.getPassword() %>"/></td> </tr>
	<tr><td>Age:</td><td><input type="number" name="age" value="<%= u.getAge()%>"/></td></tr>
	<tr><td>Job:</td><td><input type="text" name="job"value="<%= u.getJob()%>"> </td></tr>
	<tr><td>habit:</td><td><input type="text" name="habit"value="<%= u.getHabit()%>"> </td></tr>
	<tr><td>email:</td><td><input type="email" name="email" value="<%= u.getEmail()%>"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>