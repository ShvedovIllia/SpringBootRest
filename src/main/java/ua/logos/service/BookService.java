package ua.logos.service;

import java.util.List;

import ua.logos.domain.BookDTO;

public interface BookService {

	void saveBook(BookDTO book);

	BookDTO findById(Long id);

	List<BookDTO> findAllBooks();
	
	void deleteBook(Long id);
}
