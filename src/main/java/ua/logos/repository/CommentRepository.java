package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.logos.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
