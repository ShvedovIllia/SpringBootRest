package ua.logos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import ua.logos.entity.Book;
import ua.logos.entity.Category;
import ua.logos.repository.BookRepository;
import ua.logos.repository.CategoryRepository;

@SpringBootApplication
public class SpringBootRestServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootRestServerApplication.class, args);
		addCategories(context);
		addBook(context);
	}

	private static void addCategories(ConfigurableApplicationContext context) {
		List<String> categories = new ArrayList<>();
		categories.add("Comedy");
		categories.add("Fantasy");
		categories.add("Triller");
		categories.add("Horror");
		categories.add("Mistique");
		categories.add("Detective");
		categories.add("Biograph");
		categories.add("Drama");

		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		if (categoryRepository.count() == 0) {
			categories.forEach(c -> {
				Category category = new Category();
				category.setName(c);
				categoryRepository.save(category);
			});
		}
	}

	private static void addBook(ConfigurableApplicationContext context) {
		/*
		 * books.add("First book"); books.add("Second book"); books.add("Third book");
		 * books.add("Fourth book"); books.add("Fifth book"); books.add("Sixth book");
		 * books.add("Seventh book");
		 */

		BookRepository bookRepository = context.getBean(BookRepository.class);

		if (bookRepository.count() == 0) {
			for (int i = 0; i < 500; i++) {
				Book book = new Book();
				book.setAuthor("Author" + i);
				book.setDescription("description" + i);
				book.setPrice(new BigDecimal("2" + i + ".99"));
				book.setIsbn("100" + i);

				Category category = new Category();
				if (i % 2 == 0) {
					category.setId(new Long(2L));
					book.setCategory(category);
				}
				if (i % 3 == 0) {

					category.setId(new Long(5L));
					book.setCategory(category);
				}

				bookRepository.save(book);
			}
		}
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}
}
