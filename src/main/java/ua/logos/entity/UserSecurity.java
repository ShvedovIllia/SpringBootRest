package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity

public class UserSecurity extends BaseEntity {

	@Column(unique = true)
	private String username;
	@Column
	private String password;
	
	private List<Role> roles;

}
