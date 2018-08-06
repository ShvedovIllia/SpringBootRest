package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.PostDTO;
import ua.logos.entity.Post;
import ua.logos.repository.PostRepository;
import ua.logos.service.PostService;
import ua.logos.service.util.ObjectMapperUtils;

@Service

public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void addPost(PostDTO dto) {
		postRepository.save(modelMapper.map(dto, Post.class));
	}

	@Override
	public List<PostDTO> getAllPosts() {
		return modelMapper.mapAll(postRepository.findAll(), PostDTO.class);
	}

	@Override
	public PostDTO findById(Long id) {
		return modelMapper.map(postRepository.findById(id).get(), PostDTO.class);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}

}
