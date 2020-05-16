package com.wlochynski.fashiongram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.models.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
