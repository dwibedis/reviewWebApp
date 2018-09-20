<%@page info="Created by Satyad during his training period"%>
<%@page import="com.mindfire.movies.Movie"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href=".\styles\Stylings.css" />
<title>MOVIE REVIEW</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />
</head>
<body>
	<%@include file="./jsp/headerSection.jsp"%>
	<div>
		<p class="center movieName container-fluid" id="nameOfMovie">The
			largest collection of movie reviews</p>
	</div>
	<div id="result">
		<%
			Movie movie = (Movie) request.getAttribute("movie");
			if (movie == null) {
				movie = new Movie();
			}
		%>
		<%=movie.getMovieName()%>
	</div>
	<%@include file="./jsp/askReviewSection.jsp"%>
</body>
<script src=".\script\fetchResults.js"></script>
<!-- section for enabling search by enter key -->
<script>
	var input = document.getElementById("searchQuery");
	input.addEventListener("keyup", function(event) {
		event.preventDefault();
		if (event.keyCode === 13) {
			document.getElementById("searchAction").click();
		}
	});
</script>
</html>