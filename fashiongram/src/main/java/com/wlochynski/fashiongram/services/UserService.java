package com.wlochynski.fashiongram.services;

import java.util.List;

import com.wlochynski.fashiongram.models.User;


public interface UserService {
	public User findUserByEmail(String email);
	public User findUserByUserId(Integer userId);
	public void saveUser(User user);
	public void updateUserPassword(String newPassword, String email);
	public void updateUserProfile(String newName, String newEmail, int id);
	public void updateUserDescription(String description, int id);
	public List<User> findAll();
}