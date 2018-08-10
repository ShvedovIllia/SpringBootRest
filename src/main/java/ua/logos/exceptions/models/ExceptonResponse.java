package ua.logos.exceptions.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExceptonResponse {

	private Date date;
	private String description;
	private String url;
	
}
