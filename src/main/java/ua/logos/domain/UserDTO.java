package ua.logos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	private UserDTO userDTO;
}
