package com.presentationit.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.presentationit.api.model.Comment;
import com.presentationit.api.model.Post;
import com.presentationit.api.repositories.CommentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void test() {
		Post post = new Post();
		post.setTitle("test");
		post.setContent("test content");
		entityManager.persist(post);
		Comment comment1 = new Comment();
		comment1.setMessage("Comment 1");
		comment1.setPost(post);
		commentRepository.save(comment1);
		Comment comment2 = new Comment();
		comment2.setMessage("Comment 2");
		comment2.setPost(post);
		commentRepository.save(comment2);

		Iterable<Comment> comments= commentRepository.findAll();

		assertNotNull(comments);
		Iterator<Comment> it = comments.iterator();

		assertTrue(it.hasNext());
		assertEquals("Comment 1", it.next().getMessage());
		
		assertTrue(it.hasNext());
		assertEquals("Comment 2", it.next().getMessage());
		
		assertFalse(it.hasNext());
	}
}