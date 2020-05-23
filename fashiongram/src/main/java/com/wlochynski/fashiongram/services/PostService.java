package com.wlochynski.fashiongram.services;


import java.util.List;

import com.wlochynski.fashiongram.models.Post;

public interface PostService {
	public void savePost(Post post);
	public Post findFirstByOrderByIdDesc();
	public List<Post> findAllByUserId(Integer userId);
	public List<Post> findAll();
	public List<Post> findAllByOrderByIdDesc();
	List<Post> findAllByUserIdIn(List<Integer> followerId);
}
