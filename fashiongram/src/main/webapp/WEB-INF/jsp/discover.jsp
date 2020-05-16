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

<script>
	var inputComment;
	var inputCommentParent;
	window.onload = function() {
		inputComment = document.getElementById("addComment");
		inputCommentParent = document.getElementById("photodetails");
		inputCommentParent.removeChild(document.getElementById("addComment"));
	};

	function showInputComment() {
		if (document.getElementById("addComment")) {
			inputCommentParent.removeChild(document
					.getElementById("addComment"));
		} else {
			inputCommentParent.insertBefore(inputComment, document
					.getElementById("comments"));
		}

	}
</script>
</head>

<body>
	<div id="nav-placeholder">
		<ul id="nav_links">
			<li><a href="index"><img
					src="/resources/images/Icons/home.png"></a></li>
			<li><a href="discover"><img
					src="/resources/images/Icons/discoverIcon.png"></a></li>
			<li><a href="addPost"><img
					src="/resources/images/Icons/plus.png"></a></li>
			<li><a href="profile"><img
					src="/resources/images/Icons/avatar.png"></a></li>
		</ul>
	</div>

	<c:forEach varStatus="loop" var="post" items="${newPosts }">
		<div id="box">
			<div id="photo">
				<img src="/uploads/${post.photoName }">
			</div>
			<div id="photodetails">
				<div id="userbox">
					<c:forEach varStatus="loop" var="user" items="${userList }">
						<c:if test="${post.userId eq user.userId }">
							<div>
								<a href="profile/${user.userId }"><img id="avatar"
									src="uploads/${user.avatarUrl }"></a>
							</div>
							<div>
								<a id="nickname" href="profile/${user.userId }">${user.name }</a>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div id="description">
					<p>${post.description }</p>
				</div>
				<div id="products">
					<c:if test="${post.tshirtUrl ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/tshirtIcon.png"
								title="<s:message code="products.tshirtTitle"/>"><a
								class="productLink" href="${post.tshirtUrl }">${post.tshirtUrl }</a>
						</div>
					</c:if>
					<c:if test="${post.longSleeveUrl ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/longSleevesIcon.png"
								title="<s:message code="products.longSleevesTitle"/>"><a
								class="productLink" href="${post.longSleeveUrl }">${post.longSleeveUrl }</a>
						</div>
					</c:if>
					<c:if test="${post.pantsUrl ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/pantsIcon.png"
								title="<s:message code="products.pantsTitle"/>"><a
								class="productLink" href="${post.pantsUrl }">${post.pantsUrl }</a>
						</div>
					</c:if>
					<c:if test="${post.shoesUrl ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/shoesIcon.png"
								title="<s:message code="products.shoesTitle"/>"><a
								class="productLink" href="${post.shoesUrl }">${post.shoesUrl }</a>
						</div>
					</c:if>
					<c:if test="${post.others1Url ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/othersIcon.png"
								title="<s:message code="products.othersTitle"/>"><a
								class="productLink" href="${post.others1Url}">${post.others1Url}</a>
						</div>
					</c:if>
					<c:if test="${post.others2Url ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/othersIcon.png"
								title="<s:message code="products.othersTitle"/>"><a
								class="productLink" href="${post.others2Url }">${post.others2Url }</a>
						</div>
					</c:if>
					<c:if test="${post.others3Url ne '' }">
						<div id="product">
							<img class="productIcon"
								src="/resources/images/Icons/othersIcon.png"
								title="<s:message code="products.othersTitle"/>"><a
								class="productLink" href="${post.others3Url }">${post.others3Url }</a>
						</div>
					</c:if>

				</div>
				<div id="actions">

					<img src="/resources/images/Icons/likeIcon.png"
						class="actionelement"> <img
						src="/resources/images/Icons/commentIcon.png"
						onclick="showInputComment()" class="actionelement"> <img
						src="/resources/images/Icons/reportIcon.png" class="actionelement">

				</div>
				<div id="addComment">
					<input id="commentInput" placeholder="Treść komentarza" type="text">
					<button id="addCommentButton">Dodaj komentarz</button>
				</div>
				<div id="comments">
					<p>Komentarze:</p>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Co ona zrobila </a><a id="commentDate">19.02.2012r</a>
					</div>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Lorem Ipsum jest tekstem stosowanym jako
							przykładowy wypełniacz w przemyśle poligraficznym. </a><a
							id="commentDate">19.02.2012r</a>
					</div>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Lorem Ipsum jest tekstem stosowanym jako
							przykładowy wypełniacz w przemyśle poligraficznym. </a><a
							id="commentDate">19.02.2012r</a>
					</div>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Lorem Ipsum jest tekstem stosowanym jako
							przykładowy wypełniacz w przemyśle poligraficznym. </a><a
							id="commentDate">19.02.2012r</a>
					</div>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Lorem Ipsum jest tekstem stosowanym jako
							przykładowy wypełniacz w przemyśle poligraficznym. </a><a
							id="commentDate">19.02.2012r</a>
					</div>
					<div class="comment">
						<img id="commentAvatar" src="/resources/images/Icons/avatar.png">
						<a id="commentText">Lorem Ipsum jest tekstem stosowanym jako
							przykładowy wypełniacz w przemyśle poligraficznym. </a><a
							id="commentDate">19.02.2012r</a>
					</div>
				</div>

			</div>
		</div>
	</c:forEach>
</body>
</html>
