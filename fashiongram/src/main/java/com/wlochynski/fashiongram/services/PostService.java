package com.wlochynski.fashiongram.services;


import com.wlochynski.fashiongram.models.Post;

public interface PostService {
	public void savePost(Post post);
	public Post findFirstByOrderByIdDesc();
}
