package com.wlochynski.fashiongram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.models.Post;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findFirstByOrderByIdDesc();
}
