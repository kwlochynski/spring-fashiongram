package com.wlochynski.fashiongram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.models.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	public List<Comment> findAllByPostIdInOrderByIdDesc(List<Integer> postIds);
}
