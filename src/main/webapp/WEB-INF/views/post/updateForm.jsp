<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp" %>

<div class="container">
	<form>
	  <div class="form-group">
	    <input type="text" class="form-control" placeholder="Enter Title" id="title" value="${post.title}" />
	  </div>
	  
	  <div class="form-group">
	    <textarea rows="" cols="5" class="form-control" id="content">
	    	${post.content }
	    </textarea>
	  </div>
	  
	  <button type="button" id="btn-update" class="btn btn-primary" value="${post.id }">수정완료</button>
	</form>
    <script>
      $('#content').summernote({
        tabsize: 2,
        height: 300
      });
      $("#btn-update").on("click", (e)=>{
			let id = e.currentTarget.value;
			let data = {
				title : $("#title").val(),
				content : $("#content").val()		
			}
			$.ajax({
				method:"PUT",
				url : "/post/"+id,
				data : JSON.stringify(data),
				contentType: "application/json;charset=utf-8;",
				dataType:"json"
			})
			.done(res => {
				if(res.statusCode === 1){
					alert("글 수정에 성공하였습니다.");
					location.href = "/post/"+id;
				}else{
					alert("글 수정에 실패하였습니다.");
				}
			});
      });
    </script>
</div>
	
	
	
<%@include file="../layout/footer.jsp" %>
