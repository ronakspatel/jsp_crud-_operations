<%@page import="com.model.Operations_Interface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>
	<%@page import="com.bean.User"%>
	<%@page import="com.model.Operations"%>
	<%@page import="java.util.*"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Users List</h1>

	<%
	Operations_Interface operation=new Operations();
		List<User> list = operation.getAllRecords();
		request.setAttribute("list", list);
	%>
	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Sex</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getSex()}</td>
				<td>${u.getCountry()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
				<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
		</c:forEach>

	</table>
	<br/>
	<a href="adduserform.jsp">Add New User</a>
</body>
</html>