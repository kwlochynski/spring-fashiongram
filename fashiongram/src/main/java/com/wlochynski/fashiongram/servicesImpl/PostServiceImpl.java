package com.wlochynski.fashiongram.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.repositories.PostRepository;
import com.wlochynski.fashiongram.services.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public void savePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public Post findFirstByOrderByIdDesc() {
		return postRepository.findFirstByOrderByIdDesc();
	}


	
	
}
