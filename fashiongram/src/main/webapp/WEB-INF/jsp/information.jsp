<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Fashiongram</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/scrollbar.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css" />
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>



</head>

<body>
	<div id="nav-placeholder">
		<ul id="nav_links">
			<li><a href="/index" title="Strona główna"><img
					src="/resources/images/Icons/home.png"></a></li>
			<li><a href="/top" title="Najpopularniejsze"><img
					src="/resources/images/Icons/topIcon.png"></a></li>
			<li><a href="/discover" title="Odkrywaj najnowsze posty"><img
					src="/resources/images/Icons/discoverIcon.png"></a></li>
			<li><a href="/addPost" title="Dodaj post"><img
					src="/resources/images/Icons/plus.png"></a></li>
			<li><a href="/profile" title="Twój profil"><img
					class="navAvatar" src="/uploads/${user.avatarUrl }"></a></li>
		</ul>
	</div>
	
	TUTAJ BĘDĄ INFORMACJE
	
</body>
</html>
