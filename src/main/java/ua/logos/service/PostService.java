package ua.logos.service;

import java.util.List;

import ua.logos.domain.PostDTO;

public interface PostService {
	
	void addPost(PostDTO dto);

	List<PostDTO> getAllPosts();
	
	PostDTO findById(Long id);
	
	void deletePost(Long id);
}
