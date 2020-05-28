package com.wlochynski.fashiongram.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.dto.PostLikesDTO;
import com.wlochynski.fashiongram.models.Like;
import com.wlochynski.fashiongram.repositories.LikeRepository;
import com.wlochynski.fashiongram.services.LikeService;

@Service("likeService")
@Transactional
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeRepository likeRepository;

	@Override
	public void save(Like like) {
		likeRepository.save(like);
	}

	@Override
	public int countByPostIdAndUserId(int postId, int userId) {
		return likeRepository.countByPostIdAndUserId(postId, userId);
	}

	@Override
	public void deleteLike(int postId, int userId) {
		likeRepository.deleteByPostIdAndUserId(postId, userId);
	}

	@Override
	public List<PostLikesDTO> getPostsLikesDTO(List<Integer> postIds) {
		return likeRepository.getPostLikesDTO(postIds);
	}
	
	@Override
	public List<Integer> getUserLikes(int userId, List<Integer> postIds){
		return likeRepository.getUserLikes(userId, postIds);
	}
}
