<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <form action="/join" method="POST" class="box">
                    <h1>회원가입</h1>
                    <input type="text" placeholder="Username" name="username" />
                    <input type="password" placeholder="Password" name="password" />
                    <input type="text" placeholder="Email" name="email" />
                    <input type="submit" name="" value="회원가입" href="#">
                    <p>이미 회원가입이 되셨나요? <a href="/loginForm">로그인</a></p>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="../layout/footer.jsp" %>