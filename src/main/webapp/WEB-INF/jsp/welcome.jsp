<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/home.js"></script>

</head>
<body>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Can Do It</a>
			</div>
<!-- 			<div id="navbar" class="collapse navbar-collapse"> -->
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
		            <li class="nav-item" class="custom-select">
						<select class="selectpicker" data-width="fit" name="locations" id="locations">
							<c:forEach items="${locations}" var="location">
								<option value="${location.name}">
						    		${location.name}
								</option>
							</c:forEach>
						</select>
						<c:forEach items="${locations}" var="location">
							
						</c:forEach>
					</li>
		        </ul>
			</div>
	</nav>

	<div id="status">
		<p></p>
		<button class="close"><i class="fa fa-times" aria-hidden="true"></i></button>
	</div>
	<div class="container">
		<div class="row vertical-center-row">
		<div class="col">
			<div class="weather-card text-center col-md-4 col-md-offset-4">
				<div class="top">
					<div class="wrapper">
						<h1 class="heading" id="heading"></h1>
						<h3 class="location" id="location"></h3>
						<p class="temp">
							<span class="temp-value" id="temp-value"></span>
						</p>
					</div>
				</div>
		</div>
		
	</div>

	</div>
	
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
