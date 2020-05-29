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
<script>
	function getUsersSearch() {
		if ($("#searchText").val() != "") {
			$("#search").html("");
			$.ajax({
				url : '/search?param=' + $("#searchText").val(),
				success : function(data, status) {
					$(data).appendTo('#search');

				}
			})
		} else {
			$("#search").html("");
		}
	}
</script>

</head>

<body>
	<div id="nav-placeholder">
		<ul id="nav_links">
			<li><input id="searchText" class="searchInput"
				placeholder="Wyszukaj" type="text" onkeyup="getUsersSearch()">
				<div id="search" class="searchResults"></div></li>
			<li><a href="/index" title="Strona główna"><img
					src="/resources/images/Icons/home.png" class="navImage"></a></li>
			<li><a href="/discover" title="Odkrywaj posty i użytkowników"><img
					src="/resources/images/Icons/discoverIcon.png" class="navImage"></a></li>
			<li><a href="/addPost" title="Dodaj post"><img
					src="/resources/images/Icons/plus.png" class="navImage"></a></li>
			<li><a href="/profile" title="Twój profil"><img
					class="navAvatar" src="/uploads/${user.avatarUrl }"></a></li>
			<li><a href="/logout" title="Dodaj post"><img
					src="/resources/images/Icons/logoutIcon.png" class="navImage"></a></li>
		</ul>
	</div>

	TUTAJ BĘDĄ INFORMACJE

</body>
</html>
