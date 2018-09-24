<%@page info="Created by Satyad during his training period"%>
<%@page import="com.mindfire.movies.Movie"%>
<%@page import="com.mindfire.movies.Review"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./styles/Stylings.css" />
<title>MOVIE REVIEW</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />
<script src="./script/fetchResults.js"></script>
</head>
<body>
	<%@include file="./headerSection.jsp"%>
	<c:if test="${not empty movie }">
		<div>
			<p class="center movieName container-fluid" id="nameOfMovie">
				Showing Results For : ${movie.movieName }</p>
		</div>
		<div id="result" class="container-fluid ">
			<br>
			<c:forEach items="${movie.reviews }" var="review">
				<div class="boxed">
					<h2>${review.sourceName }</h2>
					<h3>${review.ratingInStars }</h3>
					<h3>${review.reviewStatement}</h3>
				</div>
				<br>
			</c:forEach>
		</div>
		<div>
			<%@include file="./askReviewSection.jsp"%>
		</div>
	</c:if>
</body>
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