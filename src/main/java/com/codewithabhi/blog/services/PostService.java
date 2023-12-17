package com.codewithabhi.blog.services;

import java.util.List;

import com.codewithabhi.blog.entities.Post;
import com.codewithabhi.blog.payloads.PostDto;
import com.codewithabhi.blog.payloads.PostResponse;

public interface PostService {
	//create
	PostDto createPost(PostDto postdto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postdto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get Single post
	PostDto getPostById(Integer postId);
	
	//get All post by Category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get All post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search Post
	List<PostDto> searchPosts(String keyword);

}
