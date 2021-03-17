<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <form action="/login" method="POST" class="box">
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your login and password!</p> 
                    <input type="text" placeholder="Username" name="username" />
                    <input type="password" placeholder="Password" name="password" />
                    <input type="submit" name="" value="Login" href="#">
                    <p>아직 회원가입안하셨나요? <a href="/joinForm" class="">회원가입하러가기</a></p>
                    <div class="col-md-12 mt-1">
                    	<div class="d-flex flex-column">
							<a href="/oauth2/authorization/google" class="btn btn-outline-secondary mt-1"><i class="fab fa-google mr-1"></i>구글 로그인</a>
							<a href="/oauth2/authorization/facebook" class="btn btn-outline-primary mt-1"><i class="fab fa-facebook-square mr-1"></i>페이스북 로그인</a>
							<a href="/oauth2/authorization/naver" class="btn btn-outline-success mt-1">네이버 로그인</a>
							<a href="/oauth2/authorization/kakao" class="btn btn-outline-warning mt-1">카카오 로그인</a>
						</div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="../layout/footer.jsp" %>
