package com.wlochynski.fashiongram.services;

import java.util.List;

import com.wlochynski.fashiongram.dto.PostLikesDTO;
import com.wlochynski.fashiongram.models.Like;

public interface LikeService {
	void save(Like like);

	int countByPostIdAndUserId(int postId, int userId);

	void deleteLike(int postId, int userId);
	
	List<PostLikesDTO> getPostsLikesDTO(List<Integer> postIds);

	List<Integer> getUserLikes(int userId, List<Integer> postIds);
}
