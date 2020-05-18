package com.wlochynski.fashiongram.services;


import com.wlochynski.fashiongram.models.Follow;

public interface FollowService {
	public void saveFollow(Follow follow);
	public int countFollowsByUserId(int userId);
	public int countFollowsByUserIdAndFollowerId(int userId, int followerId);
	public void deleteFollowByUserIdAndFollowerId( int userId, int followerId);
}
