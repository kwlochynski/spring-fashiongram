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
	$(document).bind(
			'click',
			function(e) {
				if (!$(e.target).is('#search')
						&& !$(e.target).is('#searchText')
						&& !$(e.target).is('#searchResult')) {
					$("#search").html("");
				}
			});
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
			<li><a href="/top" title="Najpopularniejsze"><img
					src="/resources/images/Icons/topIcon.png" class="navImage"></a></li>
			<li><a href="/discover" title="Odkrywaj najnowsze posty"><img
					src="/resources/images/Icons/discoverIcon.png" class="navImage"></a></li>
			<li><a href="/addPost" title="Dodaj post"><img
					src="/resources/images/Icons/plus.png" class="navImage"></a></li>
			<li><a href="/profile" title="Twój profil"><img
					class="navAvatar" src="/uploads/${user.avatarUrl }"></a></li>
			<li><a href="/logout" title="Dodaj post"><img
					src="/resources/images/Icons/logoutIcon.png" class="navImage"></a></li>
		</ul>
	</div>
	<div class="users">
		<p
			style="color: white; font-family: 'Raleway', sans-serif; margin: auto; width: 220px;">Najpopularniejsi
			użytkownicy:</p>
		<div class="top-users-swiper">
			<div class="swiper-wrapper">
				<c:forEach varStatus="loop" var="topUser"
					items="${topUsersByFollowers }">
					<div class="swiper-slide">
						<div>
							<img
								style="margin-bottom: 5px; margin-top: 10px; height: 100px; width: 100px;"
								id="avatar" src="/uploads/${topUser.avatarUrl }">
						</div>
						<div>
							<a href="/profile/${topUser.userId }" title="Zobacz profil"
								style="text-decoration: none; margin: 0px; color: white; border-bottom: 1px solid white; padding-left: 10px; padding-right: 10px; padding-bottom: -3px">${topUser.name }</a>
						</div>
						<div>
							<p style="margin: 10px; color: white">Obserwujący:
								${topUser.numberOfFollowers }</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- SWIPER -->
		<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

		<script>
			var swiper = new Swiper('.top-users-swiper', {
				grabCursor : true,
				spaceBetween : 50,
				centeredSlides : true,
				initialSlide : 2,
				slidesPerView : 'auto',
			});
		</script>

	</div>
</body>
</html>
