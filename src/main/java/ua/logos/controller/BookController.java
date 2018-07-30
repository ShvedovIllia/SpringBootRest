package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.entity.Book;
import ua.logos.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
/*
	@GetMapping("/test")
	public String test() {
		return "Hello test";
	}
*/
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody Book book){
		bookService.saveBook(book);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks(){
		
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<List<Book>> (books, HttpStatus.OK);
	}
//	
//	@GetMapping("/{bookId}")
//	public ResponseEntity <Book> getBooksById(@PathVariable("bookId") Long id){
//		
//		Book book = bookService.findById(id);
//		return new ResponseEntity<Book> (book, HttpStatus.OK);
//	}
}
