package ua.logos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.User;
import ua.logos.entity.UserSecurity;

@Repository

public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {

	boolean existsByUsername(String username);
	
	UserSecurity findByUsername(String username);
	
	@Transactional
	void deleteByUsername(String username);
	
}
