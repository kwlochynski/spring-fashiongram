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
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/resources/css/login.css" />
  	<link rel="stylesheet" href="scrollbar.css">
	<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
	<title><s:message code="logowanie.pageName" /></title>
	
	<script type="text/javascript">
	  function mylinkfunction(e) {
	  window.location.href="#register";
	  e.preventDefault();
	  e.stopPropagation();
	  }
	</script>
</head>

<body>
  <div class="container">
  	<div class="login">
      <h2 class="loginTitle">LOGOWANIE</h2>
      <div class="loginElements">
        <form class="loginForm" action="/login" method="POST">
        
          <c:if test="${not empty param.error}">
			<font color="red" size="3"><s:message code="error.logowanie"/></font>
		  </c:if>
		  
	      <p class="loginText">Login lub e-mail:</p>
	      <input class="loginInput" placeholder="Login lub e-mail" name="email" type="text">
	      
	      <p class="loginText">Hasło:</p>
	      <input class="loginInput" placeholder="Hasło" name="password" type="password">
	      
	      <div>
	       <button type="submit" class="actionButton">ZALOGUJ</button>
	      </div>
	      
	      <div id="registerOnMobile">
	       <p>Nie masz konta?</p>
	       <p id="boldText" onclick="mylinkfunction()">Zarejestruj się!</p>
	      </div>
	      
         </form>
       </div>
     </div>
   
   
   
    <div id="register" class="login">
      <h2 class="loginTitle">REJESTRACJA</h2>

	  <div style="color:green;margin:0;font-size:16px;">${message }</div>
      <div class="loginElements">
      	<sf:form class="loginForm" id="usersForm" action="adduser" modelAttribute="user"
		enctype="multipart/form-data" method="POST">
          <p class="loginText">Login</p>
          <sf:input path="name" class="loginInput" placeholder="Login" type="text"/>
          <font color="red" size="4"><sf:errors path="name"/></font>
          <p class="loginText">Email:</p>
          <sf:input path="email" class="loginInput" placeholder="Email" type="text"/>
          <font color="red" size="4"><sf:errors path="email"/></font>
          <p class="loginText">Powtórz hasło:</p>
          <sf:input path="password" class="loginInput" placeholder="Hasło" type="password"/>
          <font color="red" size="4"><sf:errors path="password"/></font>
          <div>
            <button type="submit" class="actionButton">ZAREJESTRUJ</button>
          </div>
        </sf:form>
      </div>
    </div>

  </div>

</body>
</html>
