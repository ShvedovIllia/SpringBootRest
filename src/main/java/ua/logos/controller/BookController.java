package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.BookDTO;
import ua.logos.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
	/*
	 * @GetMapping("/test") public String test() { return "Hello test"; }
	 */
	@Autowired
	private BookService bookService;
	//
	// @PostMapping
	// public ResponseEntity<Void> addBook(@RequestBody Book book){
	// bookService.saveBook(book);
	// return new ResponseEntity<> (HttpStatus.CREATED);
	//
	// }
	//
	// @GetMapping
	// public ResponseEntity<List<Book>> getBooks(){
	//
	// List<Book> books = bookService.findAllBooks();
	// return new ResponseEntity<List<Book>> (books, HttpStatus.OK);
	// }
	//
	// @GetMapping("/{bookId}")
	// public ResponseEntity <Book> getBooksById(@PathVariable("bookId") Long id){
	//
	// Book book = bookService.findById(id);
	// return new ResponseEntity<Book> (book, HttpStatus.OK);
	// }

	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
		bookService.saveBook(bookDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping("/{bookId}")
	public ResponseEntity<BookDTO> getBooksById(@PathVariable("bookId") Long id) {

		BookDTO bookDTO = bookService.findById(id);
		return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> getAllBooks() {

		List<BookDTO> booksDTO = bookService.findAllBooks();
		return new ResponseEntity<List<BookDTO>>(booksDTO, HttpStatus.OK);
	}

	@PutMapping("/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long id, @RequestBody BookDTO bookDTO) {
		BookDTO book = bookService.findById(id);
		if (book != null) {
			bookDTO.setId(id);
			bookService.saveBook(bookDTO);

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long id) {

		BookDTO book = bookService.findById(id);
		if (book != null) {
			bookService.deleteBook(book.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
