package com.wlochynski.fashiongram.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.repositories.CommentRepository;
import com.wlochynski.fashiongram.services.CommentService;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}

}
