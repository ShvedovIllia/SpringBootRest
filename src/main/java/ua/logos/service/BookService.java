package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.domain.BookDTO;
import ua.logos.domain.filter.SimpleFilter;

public interface BookService {

	void saveBook(BookDTO bookDTO);

	BookDTO findById(Long id);

	List<BookDTO> findAllBooks();
	
	void deleteBook(Long id);
	
	List<BookDTO> findByCategoryId(Long id);
	
	List<BookDTO> findAllBooksByPages(Pageable pageable);
	
	List<BookDTO> findAllBooksBySpecification(SimpleFilter filter);
	
	void saveFile(MultipartFile file);
	
	String getFile(String fileName);
	
}
