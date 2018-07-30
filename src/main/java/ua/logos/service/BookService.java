package ua.logos.service;

import java.util.List;

import ua.logos.entity.Book;

public interface BookService {

	void saveBook(Book book);

	Book findById(Long id);

	List<Book> findAllBooks();
}
