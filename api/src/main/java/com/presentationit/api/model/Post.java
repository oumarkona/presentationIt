package com.presentationit.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends AbstractEntity {

	private String title;

	private String content;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private Set<Comment> comments = new HashSet<>(0);

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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		comment.setPost(this);
		this.comments.add(comment);
	}

	public void removeComment(Comment comment) {
		comment.setPost(null);
		this.comments.remove(comment);
	}
}
