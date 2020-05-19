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



<script src="https://code.jquery.com/jquery-3.5.0.js"></script>



</head>

<body>
	<div id="nav-placeholder">
		<ul id="nav_links">
			<li><a href="/index"><img
					src="/resources/images/Icons/home.png"></a></li>
			<li><a href="/discover"><img
					src="/resources/images/Icons/discoverIcon.png"></a></li>
			<li><a href="/addPost"><img
					src="/resources/images/Icons/plus.png"></a></li>
			<li><a href="/profile"><img class="navAvatar"
					src="/uploads/${user.avatarUrl }"></a></li>
		</ul>
	</div>
	<div class="users">
		<c:forEach varStatus="loop" var="topUser"
			items="${topUsersByFollowers }">
			<div class="recommendedUser">
				<div>
					<img
						style="margin-bottom: 5px; margin-top: 10px; height: 100px; width: 100px;"
						id="avatar" src="/uploads/${topUser.avatarUrl }">
				</div>
				<div>
					<p style="margin: 0px; color: white">${topUser.name }</p>
				</div>
				<div>
					<button style="margin-top: 5px; margin-bottom: 10px;"
						class="followButton">Obserwuj</button>
				</div>
			</div>
			<div class="recommendedUser">
				<div>
					<img
						style="margin-bottom: 5px; margin-top: 10px; height: 100px; width: 100px;"
						id="avatar" src="/uploads/${topUser.avatarUrl }">
				</div>
				<div>
					<p style="margin: 0px; color: white">${topUser.name }</p>
				</div>
				<div>
					<button style="margin-top: 5px; margin-bottom: 10px;"
						class="followButton">Obserwuj</button>
				</div>
			</div>

		</c:forEach>
	</div>
</body>
</html>
