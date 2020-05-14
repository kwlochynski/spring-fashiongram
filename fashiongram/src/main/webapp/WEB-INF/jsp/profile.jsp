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
 <link rel="stylesheet" type="text/css" href="/resources/css/scrollbar.css" />
 <link rel="stylesheet" type="text/css" href="/resources/css/nav.css" />
 <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
</head>

<body>
  <div id="nav-placeholder">
    <ul id="nav_links">
      <li><a href="index"><img src="/resources/images/Icons/home.png"></a></li>
      <li><a href="addPost"><img src="/resources/images/Icons/plus.png"></a></li>
      <li><a href="profile"><img src="/resources/images/Icons/avatar.png"></a></li>
    </ul>
  </div>

<div id="profileDetails">
  <div class="profileDetail" id="profileAvatar">
    <img src="/resources/images/Icons/avatar.png">
  </div>
  <div class="profileDetail">
    <div>
      ${user.name }
    </div>
    <div class="profileDetail">
      <button id="followButton">Obserwuj</button>
    </div>
  </div>
  <div class="profileDetail" id="numberOfFollowers">Obserwujący: <br>251K</div>
</div>
<div id="description">
  <p><b>Opis: </b>Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. Został po raz pierwszy użyty w XV w. przez nieznanego drukarza do wypełnienia tekstem próbnej książki. <br>
   <b>Kategorie:</b>
   Moda damska, elegencja
 </p>


</div>


<div id="imageContainer">
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>

    </div>
  </div>
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>

    </div>
  </div>
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>

    </div>
  </div>
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>

    </div>
  </div>
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>
    </div>
  </div>
  <div class="image">
    <img src="/resources/images/Photos/2.png">
    <div class="imageText">
      <div id="likesCounter" class="counter">
        <img src="/resources/images/Icons/likeIcon.png" class="actionElement">
        <p>100</p>
      </div>
      <div id="commentsCounter" class="counter">
        <img src="/resources/images/Icons/commentIcon.png" class="actionElement">
        <p>10</p>
      </div>

    </div>
  </div>
</div>



</body>
</html>
