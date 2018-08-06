package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.PostDTO;
import ua.logos.service.PostService;

@RestController
@RequestMapping("posts")

public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/allPosts")
	public ResponseEntity<List<PostDTO>> getAllPosts() {

		return new ResponseEntity<List<PostDTO>>(HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> addPost(@RequestBody PostDTO dto) {
		postService.addPost(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<Void> deletePost(@PathVariable("postId") Long id) {
		postService.deletePost(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> findPostById(@PathVariable("postId") Long id) {

		return new ResponseEntity<PostDTO>(postService.findById(id), HttpStatus.OK);

	}

}
