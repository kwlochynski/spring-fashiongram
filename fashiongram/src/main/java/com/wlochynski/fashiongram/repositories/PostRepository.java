package com.wlochynski.fashiongram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.models.Post;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findFirstByOrderByIdDesc();
	public List<Post> findAllByUserIdOrderByIdDesc(Integer userId);
	public List<Post> findAllByOrderByIdDesc();
}
