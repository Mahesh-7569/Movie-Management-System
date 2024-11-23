<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add-movie" method="post">
		<input type="number" placeholder="Entre MovieId" name="movieId"><br>
		<input type="text" placeholder="Entre MovieTitle" name="movieTitle"><br>
		<input type="text" placeholder="Entre MovieGenre" name="movieGenre"><br>
		<input type="text" placeholder="Entre MovieDirector"name="movieDirector"><br>
		 <input type="number"placeholder="Entre MovieRating" name="movieRating"><br>
		<input type="submit" value="ADD">
	</form>
</body>
</html>