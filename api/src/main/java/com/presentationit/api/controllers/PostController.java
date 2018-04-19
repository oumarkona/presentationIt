package com.presentationit.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presentationit.api.dto.PostDto;
import com.presentationit.api.exceptions.ResourceNotFoundException;
import com.presentationit.api.model.Post;
import com.presentationit.api.repositories.PostRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/posts")
@Api(value = "/api/posts", description = "Le controleur des publications")
public class PostController extends AbstractController<Post, PostDto> {

	@Autowired
	PostRepository postRepository;

	public PostController() {
		super(Post.class, PostDto.class);
	}

	@GetMapping
	@ApiOperation(value = "Liste toutes les publications", response = PostDto.class, responseContainer = "List")
	public List<PostDto> list() {
		return map(postRepository.findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Récupère une publication", response = PostDto.class)
	public PostDto show(
			@ApiParam(value = "L'identifiant technique de la publication", required = true) @PathVariable(value = "id") Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		return map(post);
	}

	@PostMapping
	@ApiOperation(value = "Crée une publication", response = PostDto.class)
	public PostDto create(@Valid @RequestBody PostDto post) {
		Post postEntity = map(post);
		return map(postRepository.save(postEntity));
	}

	@PutMapping
	@ApiOperation(value = "Modifie une publication", response = PostDto.class)
	public PostDto update(@Valid @RequestBody PostDto post) {

		Post oldPost = postRepository.findById(post.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", post.getId()));

		oldPost.setTitle(post.getTitle());
		oldPost.setContent(post.getContent());

		Post updatedNote = postRepository.save(oldPost);
		return map(updatedNote);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Supprime une publication", response = ResponseEntity.class)
	public ResponseEntity<?> delete(
			@ApiParam(value = "L'identifiant technique de la publication", required = true) @PathVariable(value = "id") Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

		postRepository.delete(post);

		return ResponseEntity.ok().build();
	}

}
