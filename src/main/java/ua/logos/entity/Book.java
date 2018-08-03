package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor

@Table(name = "book", indexes = @Index(columnList = "title, isbn"))
public class Book extends BaseEntity {

	@Column(name="title")
	private String title;
	private String description;
	private BigDecimal price;
	private String imageURL;
	private String isbn;
	private String author;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}
