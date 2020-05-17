package com.wlochynski.fashiongram.services;

import java.util.List;

import com.wlochynski.fashiongram.models.Comment;

public interface CommentService {
	public void saveComment(Comment comment);
	public List<Comment> findAllByPostIdInOrderByIdDesc(List<Integer> postIds);
}
