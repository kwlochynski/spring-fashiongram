package com.wlochynski.fashiongram.services;


import java.util.List;

import com.wlochynski.fashiongram.models.Follow;

public interface FollowService {
	public void saveFollow(Follow follow);
	public int countFollowsByUserId(int userId);
	public int countFollowsByUserIdAndFollowerId(int userId, int followerId);
	public void deleteFollowByUserIdAndFollowerId( int userId, int followerId);
	public List<Integer> getTopUsersIdByFollowers();
	public int countFollowsByFollowerId(int followerId);
	public List<Integer> findFollowingUsers(int followerId);
}
