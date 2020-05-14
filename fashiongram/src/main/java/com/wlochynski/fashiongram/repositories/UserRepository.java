package com.wlochynski.fashiongram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.models.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public User findUserByUserId(Integer userId);
	
	@Modifying
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.email= :email")
	public void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

	@Modifying
	@Query("UPDATE User u SET u.name = :newName, u.email = :newEmail WHERE u.id = :id")
	public void updateUserProfile(@Param("newName") String newName, @Param("newEmail") String newEmail,
			@Param("id") Integer id);
	
	@Modifying
	@Query("UPDATE User u SET u.description = :description WHERE u.id = :id")
	public void updateUserDescription(@Param("description") String description, @Param("id") Integer id);
	
	
	@Modifying
	@Query("UPDATE User u SET u.avatarUrl = :avatarUrl WHERE u.id = :id")
	public void updateUserAvatarUrl(@Param("avatarUrl") String avatarUrl, @Param("id") Integer id);
	
}