package com.presentationit.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity {

	private String message;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ptr_post_id", nullable = false)
	private Post post;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
