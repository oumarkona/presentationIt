package com.presentationit.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.presentationit.api.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {


}
