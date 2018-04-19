package com.presentationit.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.presentationit.api.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
