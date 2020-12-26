<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Exploring Life - VBlogs</title>
	<meta name="generator" content="BBEdit 13.0" http-equiv="Cache-control" content="no-cache"/>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.selector-for-some-widget {
  box-sizing: content-box;
}
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

/* Header/logo Title */
.header {
  padding: 20px;
  text-align: center;
  background: #1abc9c;
  color: white;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 40px;
}

/* Style the top navigation bar */
.navbar {
  overflow: hidden;
  background-color: #333;
  margin-bottom: 0;
  height: 50px;
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 10px;
  text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  color: black;
}

.navbar [type=submit] {
	color: green;
	margin-top: 10;
	margin-bottom: 0;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: powderblue;
  padding: 20px;
}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
.jumbotron {
	text-align: center;
	background: lavenderblush;
	padding: 20px;
}

hr.a {; 
    border: none; 
    height: 8px; 
    background: red; 
	margin-top: 0px;
    margin-bottom: 4px;
}
hr.b {; 
    border: none; 
    height: 6px; 
    background: black; 
	margin-top: 0px;
    margin-bottom: 0px;
}

.card-body a{
	margin: 0;
}
</style>
</head>
<body>	
        <div class="jumbotron m-0">
			<h1 class="display-4">Vasishta Blogs</h1>
        </div>
		<hr class="a"/>
		<nav class="navbar bg-primary sticky-top">
			<div class="container-fluid">
				<div class="navbar-header">
				<form class="form-inline my-2 my-lg-0">
					<svg class="bi bi-house-door-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="white" xmlns="http://www.w3.org/2000/svg">
						<path d="M6.5 10.995V14.5a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5h-4a.5.5 0 0 1-.5-.5V11c0-.25-.25-.5-.5-.5H7c-.25 0-.5.25-.5.495z"/>
						<path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
					</svg>						
					<a class="stretched-link" href="<c:url value="homeNavigation"></c:url>">Home </a>
				</form>					
				</div> <a> | </a>				
				<a class="stretched-link" href="<c:url value="category"><c:param name="categoryType" value="categoryone"/> </c:url>">Category 1 </a>
				<a> | </a>
				<a class="stretched-link" href="<c:url value="category"><c:param name="categoryType" value="categorytwo"/> </c:url>">Category 2 </a>
				<a> | </a>
				<a class="stretched-link" href="<c:url value="category"><c:param name="categoryType" value="categorythree"/> </c:url>">Category 3 </a>								
			</div>
		</nav>
		<hr class="b"/>
		<div class="container-fluid">
			<div class="row p-2 my-3">
				<div class="col-sm-5" style="background-color:lavender;">
					<h1 class="display-4"> MOTTO <small>OF THE BLOG</small></h1>
					<br><br><br><br><br><br><br><br><br>
				</div>
				<div class="col-sm-3" style="background-color:lavenderblush;">
					<h3> QUOTE OF THE DAY </h3>
				</div>
				<div class="col-sm-4" style="background-color:lavender;">
					<h3> Author Details </h3>
					<div class="row">
						<div class="col-10 col-sm-8" style="background-color:lavender;">							
							<div class="card p-0">
								<div class="card-body">
									<h6 class="card-title">Author: Vasishta Sharma, Gudi</h6>
									<p class="card-text">Writer, Data Scientist, Researcher.</p><br>
									<p style="font-weight: bold;">Follow Vasishta</p>
									<a href="#" class="card-link">Facebook Id</a>
									<a href="#" class="card-link">LinkedIn</a>
								</div>
							</div>
						</div>
						<div class="col-2 col-sm-4" style="background-color:lavender;">
							<img src="/resources/vasi.jpg" class="img-fluid" alt="Chania" width="100" height="70">
						</div>
					</div>
					<br><br>
					<div class="row">
						<div class="col-10 col-sm-8" style="background-color:lavender;">
							<h5> Developer Credits </h5>						
							<h6 class="card-title">Mani Shankar Kulkarni</h6>
							<a href="#" class="card-link">LinkedIn</a>							
						</div>
						<div class="col-2 col-sm-4" style="background-color:lavender;">
							<!-- <img src="/resources/mani.jpg" class="img-fluid" alt="Chania" width="100" height="70"> -->
						</div>
					</div>
				</div>
			</div>
		</div>
        <div class="footer">
          <h2> contact info </h2>
        </div>
	<div class="container-fluid m-3 text-dark">
		<p style="text-align:center;">
		Copyright © 2020. All Rights Reserved.</p>
		<p style="text-align:center;">
		The copyright of the poems and quotes published in VasishtaBlogs.com belong to their respective owners. All other texts and material on this website is copyrighted.
		</p>
	</div>
</body>
</html>