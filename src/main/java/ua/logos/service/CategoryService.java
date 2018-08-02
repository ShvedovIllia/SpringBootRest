package ua.logos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.logos.domain.CategoryDTO;

@Service

public interface CategoryService {

	void saveVategory(CategoryDTO dto);

	CategoryDTO findCategoryById(Long id);

	List<CategoryDTO> findAllCategories();

}
