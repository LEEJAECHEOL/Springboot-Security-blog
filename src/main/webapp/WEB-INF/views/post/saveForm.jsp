<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp" %>

<div class="container">
	<form action="/post" method="POST">
	  <div class="form-group">
	    <input type="text" class="form-control" placeholder="Enter Title" name="title" />
	  </div>
	  
	  <div class="form-group">
	    <textarea id="summernote" rows="" cols="5" class="form-control" name="content"></textarea>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">작성</button>
	</form>
	<script>
		window.onpageshow = function (event) { 
	       if (event.persisted) { 
	            $("#summernote").text($("#녀summernote".val())
	       }
	    }
	</script>
    <script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
</div>
	
	
	
<%@include file="../layout/footer.jsp" %>
