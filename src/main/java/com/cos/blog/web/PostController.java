package com.cos.blog.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.post.Post;
import com.cos.blog.service.PostService;
import com.cos.blog.web.post.dto.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PostController {
	
	private final PostService postService;
	
	
	@GetMapping("/")
	public String findAll(Model model) { // Model : request, response, session이 안에 다 포함되어있음
		List<Post> posts = postService.전체찾기();
		model.addAttribute("posts", posts);
		return "post/list";
	}
	
	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public String save(PostSaveReqDto postSaveReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Post post = postSaveReqDto.toEntity();
		post.setUser(principalDetails.getUser());
		Post postEntity = postService.글쓰기(post);
	
		if(postEntity == null) {
			return "post/saveForm";
		}else {
			return "redirect:/post";
		}
	}

}
