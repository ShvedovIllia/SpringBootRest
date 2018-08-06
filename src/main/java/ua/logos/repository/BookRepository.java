package ua.logos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Book;

@Repository

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book>{


//	@Query("select b from Book b where b.category.id = :categoryId")
//	List<Book> findBookByCategoryId(@Param("categoryId") Long catId);
	
	List<Book> findByCategoryId(Long id);
}
