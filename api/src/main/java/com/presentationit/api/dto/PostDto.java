package com.presentationit.api.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Post", description = "Le modèle d'une publication")
public class PostDto extends AbstractDto {

	@NotBlank
	@ApiModelProperty(value = "Le titre de la publication", required = true, dataType = "String")
	private String title;

	@NotBlank
	@ApiModelProperty(value = "Le contenu de la publication", required = true, dataType = "String")
	private String content;

	private Set<CommentDto> comments = new HashSet<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}
}
