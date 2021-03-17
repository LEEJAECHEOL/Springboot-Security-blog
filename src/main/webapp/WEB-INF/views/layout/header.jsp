<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
   <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<style>
	.box {
	    width: 500px;
	    padding: 40px;
	    text-align: center;
	    transition: 0.25s;
	    margin-top: 50px
	}
	.box input[type="text"],
	.box input[type="password"] {
	    border: 0;
	    background: none;
	    display: block;
	    margin: 20px auto;
	    text-align: center;
	    border: 2px solid #3498db;
	    padding: 10px 10px;
	    width: 250px;
	    outline: none;
	    color: black;
	    border-radius: 24px;
	    transition: 0.25s
	}
	
	.box h1 {
	    color: black;
	    text-transform: uppercase;
	    font-weight: 500
	}
	
	.box input[type="text"]:focus,
	.box input[type="password"]:focus {
	    width: 300px;
	    border-color: #2ecc71
	}
	
	.box input[type="submit"] {
	    border: 0;
	    background: none;
	    display: block;
	    margin: 10px auto;
	    text-align: center;
	    border: 2px solid #2ecc71;
	    padding: 10px 100px;
	    outline: none;
	    color: black;
	    border-radius: 24px;
	    transition: 0.25s;
	    cursor: pointer
	}
	
	.box input[type="submit"]:hover {
	    background: #2ecc71
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	  <!-- Brand -->
	  <a class="navbar-brand" href="/">Blog</a>
	
	  <!-- Toggler/collapsibe Button -->
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  
	  
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <c:choose>
		  	<c:when test="${empty principal }">
		      <li class="nav-item">
		        <a class="nav-link" href="/loginForm">로그인</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/joinForm">회원가입</a>
		      </li>
		  	</c:when>
		  	<c:otherwise>
		      <li class="nav-item">
		        <a class="nav-link" href="/post/saveForm">글쓰기</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/user/${principal.user.id }">회원정보보기</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/logout">로그아웃</a>
		      </li>
		    </c:otherwise>
		  </c:choose>
	    </ul>
	  </div>
	</nav>
	<br />