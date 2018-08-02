package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.BookDTO;
import ua.logos.entity.Book;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;
import ua.logos.service.util.ObjectMapperUtils;

@Service

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveBook(BookDTO bookDTO) {
//		Book bookEntity = new Book();
//		bookEntity.setTitle(bookDTO.getTitle());
//		bookEntity.setDescription(bookDTO.getDescription());
//		bookEntity.setPrice(bookDTO.getPrice());
//		bookEntity.setAuthor(bookDTO.getAuthor());
//		bookEntity.setIsbn(bookDTO.getIsbn());
//		bookEntity.setImageURL(bookDTO.getImageURL());
		
		Book bookEntity = modelMapper.map(bookDTO, Book.class);

		bookRepository.save(bookEntity);
	}

	@Override
	public BookDTO findById(Long id) {
		Book bookEntity = bookRepository.findById(id).get();
		BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
		return bookDTO;
	}

	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> booksDTO = modelMapper.mapAll(books, BookDTO.class);
		
		return booksDTO;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<BookDTO> findByCategoryId(Long id) {
		List<Book> books = bookRepository.findByCategoryId(id);
		List<BookDTO> booksDTO = modelMapper.mapAll(books, BookDTO.class);
		return booksDTO;
	}

}
