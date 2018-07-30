package ua.logos.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "user")

public class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String email;
	private int age;
}
