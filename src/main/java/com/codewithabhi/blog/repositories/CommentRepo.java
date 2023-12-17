package com.codewithabhi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabhi.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
