package ua.logos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ua.logos.entity.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	List<User> findByPostId(Long id);
}
