package com.wlochynski.fashiongram.servicesImpl;


import java.util.List;

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

	@Override
	public List<Post> findAllByUserId(Integer userId) {
		return postRepository.findAllByUserIdOrderByIdDesc(userId);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> findAllByOrderByIdDesc() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	


	
	
}
