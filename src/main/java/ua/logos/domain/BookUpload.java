package ua.logos.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BookUpload {

	private String title;
	private BigDecimal price;
	private MultipartFile file;
	
}
