package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import ua.logos.domain.BookDTO;

public interface BookService {

	void saveBook(BookDTO bookDTO);

	BookDTO findById(Long id);

	List<BookDTO> findAllBooks();
	
	void deleteBook(Long id);
	
	List<BookDTO> findByCategoryId(Long id);
	
	List<BookDTO> findAllBooksByPages(Pageable pageable);
}
