<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Display.css">
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	%>
	<h1>All Movie Details🎬🎥🎞️</h1>
	<table border="">
		<tr class="title">
			<th>MovieId</th>
			<th>MovieTitle</th>
			<th>MovieGenre</th>
			<th>MovieDirector</th>
			<th>MovieRating</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<%
		if(rs !=null && rs.next()){
		while (rs.next()) {
		%>
		<tr class="record">
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><a href="UpdateMovieServlet?movieId=<%=rs.getInt(1)%>">UPDATE</a></td>
			<td><a href="DeleteMovieServlet?movieId=<%=rs.getInt(1)%>">DELETE</a></td>

		</tr>

		<%
		}
		}	
		else{
		%>
			<p>No movie data found</p>
		<% 
		}
		%>
	</table>
</body>
</html>