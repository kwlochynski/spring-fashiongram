package com.wlochynski.fashiongram.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlochynski.fashiongram.models.Follow;
import com.wlochynski.fashiongram.repositories.FollowRepository;
import com.wlochynski.fashiongram.services.FollowService;

@Service("followService")
public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowRepository followRepository;
	
	@Override
	public void saveFollow(Follow follow) {
		followRepository.save(follow);
	}

	@Override
	public int countFollowsByUserId(int userId) {
		return followRepository.countFollowsByUserId(userId);
	}
	
	@Override
	public int countFollowsByFollowerId(int followerId) {
		return followRepository.countFollowsByFollowerId(followerId);
	}

	@Override
	public int countFollowsByUserIdAndFollowerId(int userId, int followerId) {
		return followRepository.countFollowsByUserIdAndFollowerId(userId, followerId);
	}

	@Override
	public void deleteFollowByUserIdAndFollowerId(int userId, int followerId) {
		followRepository.deleteFollowByUserIdAndFollowerId(userId, followerId);
	}

	@Override
	public List<Integer> getTopUsersIdByFollowers() {
		return followRepository.getTopUsersIdByFollowers();
	}

}
