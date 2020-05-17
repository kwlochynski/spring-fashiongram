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
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/scrollbar.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/nav.css" />
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	var loadFile = function(event) {
		var output = document.getElementById('uploadedImage');
		output.src = URL.createObjectURL(event.target.files[0]);
		output.onload = function() {
			URL.revokeObjectURL(output.src)
		}
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
			<li><a href="profile"><img class="navAvatar"
					src="/uploads/${user.avatarUrl }"></a></li>
		</ul>
	</div>

	<sf:form action="/upload" method="post" enctype="multipart/form-data"
		modelAttribute="uploadPost">
		<div class="box">
			<div id="photo">
				<img id="uploadedImage" title="<s:message code="post.add.photo"/>"
					src="/resources/images/Photos/addPhoto.png" class="addPhotoHover"
					onclick="document.getElementById('file').click();"> <input
					type="file" style="display: none;" id="file" name="fileupload"
					accept="image/*" onchange="loadFile(event)" />
			</div>
			<div id="photodetails">
				<div id="userbox">
					<div>
						<img id="avatar" src="/uploads/${user.avatarUrl }"></img>
					</div>
					<div>
						<a id="nickname" href="profile/${user.userId }">${user.name }</a>
					</div>

				</div>
				<div id="description">
					<p>Opis:</p>
					<textarea name="description" id="descriptionInput"
						placeholder="Opis" rows="5" cols="80"></textarea>
				</div>
				<div id="products">
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/tshirtIcon.png"
							title="<s:message code="products.tshirtTitle"/>"><input
							name="tshirtUrl" class="inputProduct" type="text"
							placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/longSleevesIcon.png"
							title="<s:message code="products.longSleevesTitle"/>"><input
							name="longSleeveUrl" class="inputProduct" type="text"
							placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/pantsIcon.png"
							title="<s:message code="products.pantsTitle"/>"
							style="height: 30px; width: 25px; margin-left: 2.5px; margin-right: 12.5px;"><input
							name="pantsUrl" class="inputProduct" type="text"
							placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/shoesIcon.png"
							title="<s:message code="products.shoesTitle"/>"
							style="height: 20px;"><input name="shoesUrl"
							class="inputProduct" type="text" placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/othersIcon.png"
							title="<s:message code="products.othersTitle"/>"><input
							name="others1Url" class="inputProduct" type="text"
							placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/othersIcon.png"
							title="<s:message code="products.othersTitle"/>"><input
							name="others2Url" class="inputProduct" type="text"
							placeholder="Link">
					</div>
					<div id="product">
						<img class="productIcon"
							src="/resources/images/Icons/othersIcon.png"
							title="<s:message code="products.othersTitle"/>"><input
							name="others3Url" class="inputProduct" type="text"
							placeholder="Link">
					</div>
				</div>
				<div id="addPhoto">
					<button type="submit" id="addCommentButton">Dodaj post</button>
				</div>
				<div
					style="color: red; text-align: center; font-size: 20px; margin-top: 20px;">
					${error }</div>
			</div>
		</div>
	</sf:form>

</body>
</html>
