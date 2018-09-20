var movies = [
		{
			movieName : "Schindler's List",
			reviews : [
					{
						sourceName : "IMDB",
						ratings : "* * * * *",
						statement : 'In German-occupied Poland during World War'
								+ 'II, Oskar Schindlergradually becomes concerned for his Jewish workforce'
								+ 'after witnessing their persecution by the Nazi Germans'
					},
					{
						sourceName : "Rotten Tomatoes",
						ratings : "* * * *",
						statement : 'Schindler\'s List blends the abject horror of the Holocaust'
								+ 'with Steven Spielberg\'s signature tender humanism to create the'
								+ 'director\'s dramatic masterpiece'
					},
					{
						sourceName : "Mind Fire",
						ratings : "* * * * *",
						statement : 'It\'s an outstanding and awesome movie and it\'s a great movie'
								+ 'as a whole not just story wise or direction. We would like to such'
								+ 'movies in future.'
					} ]
		},
		{
			movieName : "Shawsank Redemption",
			reviews : [
					{
						sourceName : "IMDB",
						ratings : "* * * *",
						statement : 'Two imprisoned men bond over a number of years,'
								+ 'finding solace and eventual redemption through acts of common'
								+ 'decency.'
					},
					{
						sourceName : "Rotten Tomatoes",
						ratings : "* * * * *",
						statement : 'The Shawshank Redemption is an uplifting,'
								+ 'deeply satisfying prison drama with sensitive direction'
								+ 'and fine performances.'
					},
					{
						sourceName : "Mind Fire",
						ratings : "* * * * *",
						statement : 'It\'s an outstanding and awesome movie and it\'s a great movie'
								+ 'as a whole not just story wise or direction. We would like to such'
								+ 'movies in future.'
					} ]
		} ];

function search() {
	document.getElementById("askReview").classList.remove("hidden");
	var query = document.getElementById("searchQuery").value;
	var movieNameDiv = document.getElementById("nameOfMovie");
	movieNameDiv.innerHTML = query;
	var index = searchMovieName(query);
	if (index != -1) {
		loadData(index);
	} else {
		loadRsultNotFound();
	}
}

function searchMovieName(query) {
	for (var i = 0; i < movies.length; i++) {
		if (movies[i].movieName === query) {
			return i;
		}
	}
	return -1;
}

function loadData(index) {
	removePreviousChildren(document.getElementById("result"));
	var div, h2, h3, h3Para;

	for (var i = 0; i < movies[index].reviews.length; i++) {
		div = document.createElement("div");
		div.classList.add("boxed");
		h2 = document.createElement("h2");
		h3 = document.createElement("h3");
		h3Para = document.createElement("h3");

		h2.appendChild(document
				.createTextNode(movies[index].reviews[i].sourceName));
		h3.appendChild(document
				.createTextNode(movies[index].reviews[i].ratings));
		h3Para.appendChild(document
				.createTextNode(movies[index].reviews[i].statement));

		div.appendChild(h2);
		div.appendChild(h3);
		div.appendChild(h3Para);

		document.getElementById("result").appendChild(div);
	}
}

function loadRsultNotFound() {
	removePreviousChildren(document.getElementById("result"));
	document.getElementById("result").appendChild(
			document.createTextNode("Sorry No results avialable"));
}

function removePreviousChildren(parent) {
	while (parent.firstChild) {
		parent.firstChild.remove();
	}
}

function submitReview() {
	var newReview = new Object();
	newReview.sourceName = "mindfire Employee";
	newReview.ratings = document.getElementById("rating").value;
	newReview.statement = document.getElementById("review").value;
	var movieName = document.getElementById("searchQuery").value;
	var index = searchMovieName(movieName);
	if (index != -1) {
		movies[index].reviews.push(newReview);
	} else {
		var newMovie = new Object();
		newMovie.movieName = movieName;
		newMovie.reviews = [ newReview ];
		movies.push(newMovie);
	}
	document.getElementById("askReview").classList.add("hidden");
	reset();
}

function reset() {
	removePreviousChildren(document.getElementById("result"));
	document.getElementById("nameOfMovie").innerHTML = 'The largest collection of'
			+ 'movie reviews';
	document.getElementById("review").value = "";
	document.getElementById("rating").value = "";
}