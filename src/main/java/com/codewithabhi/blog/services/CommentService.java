package com.codewithabhi.blog.services;

import com.codewithabhi.blog.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer CommentId);
	
	
}
