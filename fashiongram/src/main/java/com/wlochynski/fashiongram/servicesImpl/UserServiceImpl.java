package com.wlochynski.fashiongram.servicesImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.dto.TopUserDTO;
import com.wlochynski.fashiongram.models.Role;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.repositories.RoleRepository;
import com.wlochynski.fashiongram.repositories.UserRepository;
import com.wlochynski.fashiongram.services.UserService;



@Service("userService")
@Transactional
 public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	public User findUserByUserId(Integer userId) {
		return userRepository.findUserByUserId(userId);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);

		Role role = roleRepository.findByRole("ROLE_ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		
		userRepository.save(user);
		
	}
	
	@Override
	public void updateUserPassword(String newPassword, String email)
	{
		userRepository.updateUserPassword(bCryptPasswordEncoder.encode(newPassword), email);
	}

	@Override
	public void updateUserProfile(String newName, String newEmail, int id) {
		userRepository.updateUserProfile(newName, newEmail, id);
		
	}

	@Override
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public void updateUserDescription(String description, int id) {
		userRepository.updateUserDescription(description, id);
	}

	@Override
	public void updateUserAvatarUrl(String avatarUrl, int id) {
		userRepository.updateUserAvatarUrl(avatarUrl, id);
	}

	@Override
	public List<User> findAllById(List<Integer> userIds) {
		List<User> userList = userRepository.findAllById(userIds);
		return userList;
	}

	@Override
	public List<TopUserDTO> getTopUserDTO(Pageable pageable) {
		return userRepository.getTopUserDTO(pageable);
	}

	@Override
	public List<TopUserDTO> getTopUserBySearchParam(String param, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.getTopUserBySearchParam(param, pageable);
	}
}
