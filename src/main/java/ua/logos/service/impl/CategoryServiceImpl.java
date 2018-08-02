package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.CategoryDTO;
import ua.logos.entity.Category;
import ua.logos.repository.CategoryRepository;
import ua.logos.service.CategoryService;
import ua.logos.service.util.ObjectMapperUtils;

@Service

public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveVategory(CategoryDTO dto) {
		Category category = modelMapper.map(dto, Category.class);
		categoryRepository.save(category);
	}

	@Override
	public CategoryDTO findCategoryById(Long id) {
		Category category = categoryRepository.findById(id).get();
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> findAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDTO>categoriesDTO = modelMapper.mapAll(categories, CategoryDTO.class);
		return categoriesDTO;
	}

}
