package com.cos.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.config.handler.exception.NotIdException;
import com.cos.blog.domain.post.Post;
import com.cos.blog.domain.post.PostRepository;
import com.cos.blog.web.post.dto.PostSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	
	private final PostRepository postRepository;
	
	@Transactional(readOnly = true)
	public Page<Post> 전체찾기(Pageable pageable){
		return postRepository.findAll(pageable);
	}
	
	@Transactional
	public Post 글쓰기(Post post) {
		return postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
	public Post 상세보기(int id) {
		return postRepository.findById(id).orElseThrow(()-> new NotIdException("존재하지 않는 게시글입니다."));
	}
	
	@Transactional
	public void 삭제하기(int id) {
		postRepository.deleteById(id);
	}
	
	@Transactional
	public void 수정하기(int id, PostSaveReqDto postSaveReqDto) {
		Post postEntity = postRepository.findById(id).orElseThrow(()-> new NotIdException("존재하지 않는 게시글입니다."));
		postEntity.setTitle(postSaveReqDto.getTitle());
		postEntity.setContent(postSaveReqDto.getContent());
	}
	
}
