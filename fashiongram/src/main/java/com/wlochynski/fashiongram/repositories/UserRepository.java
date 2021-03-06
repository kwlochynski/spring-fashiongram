package com.wlochynski.fashiongram.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlochynski.fashiongram.dto.TopUserDTO;
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
	
	@Query("SELECT new com.wlochynski.fashiongram.dto.TopUserDTO(u.userId, u.name, u.avatarUrl, count(f.userId) as numberOfFollowers) FROM User u JOIN Follow f on u.userId = f.userId GROUP BY f.userId ORDER BY numberOfFollowers DESC")
	public List<TopUserDTO> getTopUserDTO(Pageable pageable);
	
	@Query("SELECT new com.wlochynski.fashiongram.dto.TopUserDTO(u.userId, u.name, u.avatarUrl, count(f.userId) as numberOfFollowers) FROM User u JOIN Follow f on u.userId = f.userId WHERE u.name LIKE :param GROUP BY f.userId ORDER BY numberOfFollowers DESC")
	public List<TopUserDTO> getTopUserBySearchParam(@Param("param") String param, Pageable pageable);
	
	//SELECT u.user_id, u.name, u.avatar_url, count(f.user_id) as numberOfFollowers FROM User u JOIN Follow f on u.user_id = f.user_id WHERE u.name LIKE '%:as%' GROUP BY f.user_id ORDER BY numberOfFollowers DESC
}