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

import com.presentationit.api.dto.CommentDto;
import com.presentationit.api.exceptions.ResourceNotFoundException;
import com.presentationit.api.model.Comment;
import com.presentationit.api.repositories.CommentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/comments")
@Api(value = "/api/comments", description = "Le controleur des commentaires")
public class CommentController extends AbstractController<Comment, CommentDto> {

	@Autowired
	CommentRepository commentRepository;

	public CommentController() {
		super(Comment.class, CommentDto.class);
	}

	@GetMapping
	@ApiOperation(value = "Liste toutes les commentaires", response = CommentDto.class, responseContainer = "List")
	public List<CommentDto> list() {
		return map(commentRepository.findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Récupère un commentaire", response = CommentDto.class)
	public CommentDto show(
			@ApiParam(value = "L'identifiant technique du commentaire", required = true) @PathVariable(value = "id") Long id) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));

		return map(comment);
	}

	@PostMapping
	@ApiOperation(value = "Crée un commentaire", response = CommentDto.class)
	public CommentDto create(@Valid @RequestBody CommentDto post) {
		Comment commentEntity = map(post);
		return map(commentRepository.save(commentEntity));
	}

	@PutMapping
	@ApiOperation(value = "Modifie un commentaire", response = CommentDto.class)
	public CommentDto update(@Valid @RequestBody CommentDto comment) {

		Comment oldComment = commentRepository.findById(comment.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", comment.getId()));

		oldComment.setMessage(comment.getMessage());

		Comment updatedNote = commentRepository.save(oldComment);
		return map(updatedNote);
	}

	@DeleteMapping( "/{id}")
	@ApiOperation(value = "Supprime un commentaire", response = CommentDto.class)
	public ResponseEntity<?> delete(
			@ApiParam(value = "L'identifiant technique du commentaire", required = true) @PathVariable(value = "id") Long id) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));

		commentRepository.delete(comment);

		return ResponseEntity.ok().build();
	}

}
