<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Fashiongram</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/resources/css/profile.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/scrollbar.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css" />
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<script>
	function showEditDescription() {
		var x = document.getElementById("editProfileDescription");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
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
	<div id="profileDetails">

		<c:choose>
			<c:when test="${ifLoggedUserProfile }">
				<sf:form action="/editProfileAvatar" method="post"
					enctype="multipart/form-data">
					<div class="profileDetail" id="profileAvatar">
						<img style="cursor: pointer" id="uploadedImage"
							title="<s:message code="post.add.photo"/>"
							src="/uploads/${user.avatarUrl }" class="addPhotoHover"
							onclick="document.getElementById('file').click();"> <input
							type="file" style="display: none;" id="file" name="fileupload"
							accept="image/*" onchange="this.form.submit()">
					</div>
				</sf:form>
			</c:when>
			<c:otherwise>
				<div class="profileDetail" id="profileAvatar">
					<img id="uploadedImage" src="/uploads/${user.avatarUrl }"
						class="addPhotoHover">
				</div>
			</c:otherwise>
		</c:choose>


		<div class="profileDetail">
			<div>${user.name }</div>
			<div class="profileDetail">
				<c:if test="${!ifLoggedUserProfile }">
					<c:choose>
					<c:when test="${isFollowing }">
						<button onclick="location.href='/follow/${user.userId }'" class="roundButton">Przestań obserwować</button>
					</c:when>
					<c:otherwise>
						<button onclick="location.href='/follow/${user.userId }'" class="roundButton">Obserwuj</button>
					</c:otherwise>
					</c:choose>
				</c:if>
			</div>

		</div>
		<div class="profileDetail" id="numberOfFollowers">Obserwujący:
			${numberOfFollowers }</div>
	</div>
	<div id="description">
		<p>
			<c:if test="${ifLoggedUserProfile }">
				<img style="width: 30px; height: 30px; cursor: pointer;"
					src="/resources/images/Icons/editIcon.png"
					onclick="showEditDescription()">
			</c:if>
					 ${user.description }
		
		</p>
	</div>

	<sf:form action="/editProfileDescription" method="post"
		enctype="multipart/form-data">
		<div style="display: none;" id="editProfileDescription">
			<textarea name="description" id="descriptionInput" placeholder="Opis"
				rows="5" style="width: 600px;"></textarea>
			<button type="submit" style="margin-top: 10px;" class="roundButton">Zapisz</button>
		</div>
	</sf:form>

	<div id="imageContainer">
		<c:forEach varStatus="loop" var="post" items="${listOfUserPosts }">
			<div class="image">
				<img src="/uploads/${post.photoName }">
				<div class="imageText">
					<div id="likesCounter" class="counter">
						<img src="/resources/images/Icons/likeIcon.png"
							class="actionElement">
						<p>100</p>
					</div>
					<div id="commentsCounter" class="counter">
						<img src="/resources/images/Icons/commentIcon.png"
							class="actionElement">
						<p>10</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
