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
	/* 	var inputComment;
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
	 */
</script>

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>
function addComment(postId) {
	var form = $('#addCommentForm'+postId);
	var commentContent = $('#commentContent'+postId).val();
		$
			.ajax({
					type : "post",
					url : form.attr('action'),
					data : form.serialize(),
					success : function() {
					$(
					"<div class='comment'><img class='commentAvatar' src='/uploads/${user.avatarUrl }'><a id='commentText'> "+ commentContent +" </a><a id='commentDate'>Dodano: Przed chwilą</a></div>")
					.prependTo('#comments'+postId);
					}
				})
			};
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
		<div class="box" id="post${post.id }">
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
								title="<s:message code="products.pantsTitle"/>"
								style="height: 30px; width: 25px; margin-left: 2.5px; margin-right: 12.5px;"><a
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

				<form id="addCommentForm${post.id }"
					action="/addComment/${post.id }" method="post">
					<div id="addComment">
						<input id="commentContent${post.id }" name="commentContent"
							class="commentInput" placeholder="Treść komentarza" type="text">
						<input id="addCommentButton" type="button" value="Dodaj komentarz"
							onClick="addComment(${post.id})">
					</div>
				</form>
				
				<p class="commentsText">Komentarze:</p>
				<div class="comments" id="comments${post.id }">
					<c:forEach varStatus="loop" var="comment" items="${commentList }">
						<c:if test="${post.id eq comment.postId }">
							<div class="comment">
								<c:forEach varStatus="loop" var="commentUser"
									items="${commentUserList }">
									<c:if test="${comment.userId eq commentUser.userId }">
										<img class="commentAvatar"
											src="/uploads/${commentUser.avatarUrl }">
										<a class="commentText">${comment.content }</a>
										<a id="commentDate">${comment.addDate.time }</a>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</c:forEach>
				</div>


			</div>
		</div>
	</c:forEach>
</body>
</html>
