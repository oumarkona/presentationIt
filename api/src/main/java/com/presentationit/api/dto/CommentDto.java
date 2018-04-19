package com.presentationit.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Comment", description = "Le modèle d'un commentaire")
public class CommentDto extends AbstractDto {

	@NotBlank
	@ApiModelProperty(value = "Le message du commentaire", required = true, dataType = "String")
	private String message;

	@NotNull
	@ApiModelProperty(value = "L'identifiant technique d'une publication", required = true, dataType = "Long")
	private Long postId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
}
