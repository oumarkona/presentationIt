package com.presentationit.api;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.presentationit.api.model.Post;
import com.presentationit.api.repositories.PostRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostRepository postRepository;

	@Test
	public void test() {
		Post post = new Post();
		post.setTitle("test");
		post.setContent("test content");
		entityManager.persist(post);

		Optional<Post> savedPost = postRepository.findById(post.getId());

		assertTrue(savedPost.isPresent());

		assertNotNull(savedPost.get().getCreatedAt());
		assertNotNull(savedPost.get().getUpdatedAt());
		assertEquals("test", savedPost.get().getTitle());

		assertEquals("test content", savedPost.get().getContent());
	}
}