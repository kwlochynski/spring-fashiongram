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
	function addComment(postId) {
		var form = $('#addCommentForm' + postId);
		var commentContent = $('#commentContent' + postId).val();
		$
				.ajax({
					type : "post",
					url : form.attr('action'),
					data : form.serialize(),
					success : function() {
						$(
								"<div class='comment'><img class='commentAvatar' src='/uploads/${user.avatarUrl }'><a id='commentText'> "
										+ commentContent
										+ " </a><a id='commentDate'>Dodano: Przed chwilą</a></div>")
								.prependTo('#comments' + postId);
					}
				})
	};

	function like(postId, numberOfLikes) {
		var title = document.getElementById("numberOfLikes"+postId).innerHTML;
		var likes = parseInt(title.split(' ')[0], 10);
		if((document.getElementById("likeButton"+postId).src).includes("/resources/images/Icons/likeIcon.png")) {
			document.getElementById("likeButton"+postId).src="/resources/images/Icons/likedIcon.png";
			likes++;
		}
		else{
			document.getElementById("likeButton"+postId).src="/resources/images/Icons/likeIcon.png";
			likes--;
		}
		
		if(likes == 1)
			document.getElementById("numberOfLikes"+postId).innerHTML = likes +" osoba lubi to!";	
		if(likes == 2 || likes == 3 || likes == 4)
			document.getElementById("numberOfLikes"+postId).innerHTML = likes +" osoby lubią to!";	
		if(likes > 4 || likes == 0)
			document.getElementById("numberOfLikes"+postId).innerHTML = likes +" osób lubi to!";	
		
		$.ajax({
			type : "post",
			url : "/like/" + postId,
			success : function() {

			}
		})
	};

	$(document).bind('click', function(e) {
		  if(!$(e.target).is('#search') && !$(e.target).is('#searchText') && !$(e.target).is('#searchResult')) {
			  $("#search").html("");
		  }
		});

	function getUsersSearch() {
		if($("#searchText").val() != "")
			{
		$("#search").html("");
		$.ajax({
			url: '/search?param='+$("#searchText").val(),
			success : function(data, status) {
				$(data).appendTo('#search');
				
				}
			})
		}
		else{
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
	<c:if test="${topUsersByFollowers ne null}">
		<div class="users">
			<p
				style="color: white; font-family: 'Raleway', sans-serif; margin: auto; width: 220px;text-align:center">Najpopularniejsi
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
	</c:if>
	<c:if test="${topUsersByFollowers ne null}">
	<p
		style="color: white; font-family: 'Raleway', sans-serif; margin: auto; margin-top:30px; margin-bottom:-9vh; position:relative;z-index:10; width: 200; text-align:center">Najnowsze
		posty:</p>
	</c:if>
	<c:forEach varStatus="loop" var="post" items="${posts }">
		<div class="box" id="post${post.id }">
			<div id="photo">
				<img src="/uploads/${post.photoName }">
			</div>
			<div id="photodetails">
				<div id="userbox">

					<div>
						<a href="profile/${post.userId }"><img id="avatar"
							src="/uploads/${post.postedUserAvatar }"></a>
					</div>
					<div>
						<a id="nickname" href="profile/${post.userId }">${post.postedUserName }</a>
					</div>

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
					<c:set var="contains" value="false" />
					<c:choose>
						<c:when test="${not empty userLikes}">
							<c:forEach varStatus="loop" var="likedPost" items="${userLikes }">
								<c:if test="${likedPost eq post.id }">
									<c:set var="contains" value="true" />
								</c:if>
							</c:forEach>

							<c:choose>
								<c:when test="${contains eq true }">
									<img src="/resources/images/Icons/likedIcon.png"
										class="actionelement" id="likeButton${post.id }"
										onClick="like(${post.id},${post.numberOfLikes })">
								</c:when>
								<c:otherwise>
									<img src="/resources/images/Icons/likeIcon.png"
										class="actionelement" id="likeButton${post.id }"
										onClick="like(${post.id},${post.numberOfLikes })">
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<img src="/resources/images/Icons/likeIcon.png"
								class="actionelement" id="likeButton${post.id }"
								onClick="like(${post.id},${post.numberOfLikes })">
						</c:otherwise>
					</c:choose>
					<img src="/resources/images/Icons/commentIcon.png"
						onclick="showInputComment()" class="actionelement"> <img
						src="/resources/images/Icons/reportIcon.png" class="actionelement">
				</div>



				<c:choose>
					<c:when test="${post.numberOfLikes == 1}">
						<p class="commentsText" id="numberOfLikes${post.id}">${post.numberOfLikes }
							osoba lubi to!</p>
					</c:when>

					<c:when
						test="${post.numberOfLikes == 2 || post.numberOfLikes == 3 || post.numberOfLikes == 4}">
						<p class="commentsText" id="numberOfLikes${post.id}">${post.numberOfLikes }
							osoby lubią to!</p>
					</c:when>

					<c:otherwise>
						<p class="commentsText" id="numberOfLikes${post.id}">${post.numberOfLikes }
							osób lubi to!</p>
					</c:otherwise>

				</c:choose>





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
