package ua.logos.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
	ADMIN, CLIENT;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name();
	}
}
