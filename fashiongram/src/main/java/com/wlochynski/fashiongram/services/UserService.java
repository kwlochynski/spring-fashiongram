package com.wlochynski.fashiongram.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wlochynski.fashiongram.dto.TopUserDTO;
import com.wlochynski.fashiongram.models.User;


public interface UserService {
	public User findUserByEmail(String email);
	public User findUserByUserId(Integer userId);
	public void saveUser(User user);
	public void updateUserPassword(String newPassword, String email);
	public void updateUserProfile(String newName, String newEmail, int id);
	public void updateUserDescription(String description, int id);
	public void updateUserAvatarUrl(String avatarUrl, int id);
	public List<User> findAllById(List<Integer> userIds);
	public List<User> findAll();
	public List<TopUserDTO> getTopUserDTO(Pageable pageable);

}