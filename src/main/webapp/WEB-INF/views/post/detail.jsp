<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp" %>
	
	<div class="container">
		<div>
			<div class="d-flex justify-content-end">
				<button class="btn btn-secondary " onClick="history.go(-1)">뒤로가기</button>
				<c:if test="${post.user.id == principal.user.id }">
					<a href="/post/${post.id }/updateForm" class="btn btn-warning ml-1">수정</a>
					<button id="btn-delete" class="btn btn-danger ml-1" value="${post.id }">삭제</button>
				</c:if>
			</div>
			<div class="d-flex justify-content-between mt-2">
				<span>글번호 : ${post.id }</span> <span>작성자 : ${post.user.username }</span>
			</div>			
			<hr />
			<div class="pl-2">
				<h3>${post.title }</h3>
			</div>
			<hr />
			<div>
				<div class="p-2">${post.content }</div>
			</div>
		</div>
		<!-- 댓글 시작 -->
		<div class="card">
			<form>
				<input type="hidden" id="postId" value="${post.id}">
				<input type="hidden" id="userId" value="${principal.user.id}">
				<div class="card-body">
					<textarea id="reply-content" class="form-control" rows="3"></textarea>
				</div>
				<div class="card-footer d-flex justify-content-end bg-white">
					<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
		<br />
		
		<div class="">
			<div class="card-header bg-white mb-1">Comment</div>
			<div class=" d-flex flex-column pl-1 pr-1">
				<c:forEach var="reply" items="${post.replys }">
					<div id="reply-${reply.id }" class="card d-flex flex-column mt-2 p-2">
						<div class="d-flex justify-content-between p-2">
							<div class="font-italic p-2"><i class="fas fa-user mr-2"></i>${reply.user.username }</div>
							<c:if test="${reply.user.id == principal.user.id }">
								<button onClick="deleteReply(${reply.id})" class="badge btn"><i class="far fa-trash-alt"></i></button>
							</c:if>
						</div>
						<div class="d-flex p-2 pl-4">
							${reply.content }
						</div> <!-- 레이지로딩 시작 - 이유는 getter호출되니깐 (세션이 열려있음 open in view 모드에서만) -->
					</div>
				</c:forEach>
			</div>
		</div>
<!-- 댓글 끝 -->
		
	</div>
<script type="text/javascript">
	$("#btn-reply-save").on("click", () => {
		let data = {
			content: $("#reply-content").val(),
			userId: $("#userId").val(),
			postId: $("#postId").val(),
		}
		$.ajax({
			method:"POST",
			url : "/reply",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8;",
			dataType:"json"
		})
		.done(res => {
			if(res.statusCode === 1){
				location.reload(true);
			}else{
				alert("댓글 저장에 실패하였습니다.");
			}
		});

	});

	function deleteReply(id){
		console.log(id);
		$.ajax({
			method:"DELETE",
			url : "/reply/"+id,
			dataType:"json"
		})
		.done(res => {
			if(res.statusCode === 1){
				$("#reply-" + id).remove();
			}else{
				alert("글 삭제에 실패하였습니다.");
			}
		});
	}
	$("#btn-delete").on("click", (e) => {
		let id = e.currentTarget.value;

		$.ajax({
			type:"DELETE",
			url:"/post/"+id,
			dataType:"json"
		})
		.done(res=>{
			if(res.statusCode === 1){
				console.log(res);
				alert("삭제에 성공하였습니다.");
				history.go(-1);
			}else{
				alert("삭제에 실패하였습니다.");
			}
		});
	});
</script>
	
<%@include file="../layout/footer.jsp" %>
