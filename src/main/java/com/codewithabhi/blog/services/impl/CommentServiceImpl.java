package com.codewithabhi.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithabhi.blog.entities.Comment;
import com.codewithabhi.blog.entities.Post;
import com.codewithabhi.blog.exceptions.ResourceNotFoundException;
import com.codewithabhi.blog.payloads.CommentDto;
import com.codewithabhi.blog.repositories.CommentRepo;
import com.codewithabhi.blog.repositories.PostRepo;
import com.codewithabhi.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;  
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post Id",postId));
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment=this.commentRepo.save(comment);
		// TODO Auto-generated method stub
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","Comment Id",commentId));
		this.commentRepo.delete(com);
		// TODO Auto-generated method stub

	}

}
