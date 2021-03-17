<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<div class="container ">
	<form>
	  <div class="form-group">
	    <label for="uname">Username</label>
		<input type="hidden" value="${id }" id="id" />
		<input type="text" class="form-control" value="${principal.user.username }" placeholder="Username" id="username" readonly="readonly" />
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password</label>
	    <input type="password" class="form-control" value="" placeholder="Password" id="password" />
	  </div>
	  <div class="form-group">
	    <label for="pwd">Email</label>
	    <input type="text" class="form-control" value="${principal.user.email }" placeholder="Email" id="email" />
	  </div>
	  <button id= "btn-update" class="btn btn-primary">회원수정</button>
	</form>
	<form>
		<br />
		
		
	</form>
</div>

<script>
	$("#btn-update").on("click", (e)=>{
		e.preventDefault();
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		let id = $("#id").val();

		$.ajax({
			type:"PUT",
			url:"/user/"+id,
			data: JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json"
		})
		.done((res)=>{
			if(res.statusCode === 1){
				alert("수정에 성공하였습니다.");
				location.href="/";
			}else{
				alert("수정에 실패하였습니다.");
			}
		});
	});
</script>
<%@include file="../layout/footer.jsp" %>
