<div id="askReview" class="container-fluid">
	<form action="/reviews/submit" method="Get">
		<div class="form-group">
			<label>Submit Review:</label> <br>
			<input type = "text" id = "rating" name = "rating" placeholder = "rating">
			<textarea class="form-control" rows="5" id="review"
				name="reviewStatement"></textarea>
		</div>
		<button type="submit" id="reviewSubmission" class="btn btn-lg">Submit</button>
		<input type="text" id="movieName" name="movieName" class="hidden"
			value="${movie.movieName }">
	</form>
</div>

