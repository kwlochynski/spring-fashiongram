package com.wlochynski.fashiongram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.models.Follow;

@Transactional
@Repository("followRepository")
public interface FollowRepository extends JpaRepository<Follow, Integer> {
	
	@Query("SELECT COUNT(*) FROM Follow WHERE user_id =:userId")
	public int countFollowsByUserId(@Param("userId") int userId);
	
	@Query("SELECT COUNT(*) FROM Follow WHERE follower_id =:followerId")
	public int countFollowsByFollowerId(@Param("followerId") int followerId);
	
	@Query("SELECT COUNT(*) FROM Follow WHERE user_id =:userId and follower_id =:followerId")
	public int countFollowsByUserIdAndFollowerId(@Param("userId") int userId, @Param("followerId") int followerId);
	
	
	@Modifying
	@Query("DELETE FROM Follow WHERE user_id =:userId and follower_id =:followerId")
	public void deleteFollowByUserIdAndFollowerId(@Param("userId") int userId, @Param("followerId") int followerId);
	
	
	@Query(value = "SELECT user_id FROM Follow GROUP BY user_id ORDER BY count(user_id) LIMIT 20", nativeQuery = true)
	public List<Integer> getTopUsersIdByFollowers();
	
	@Query(value = "SELECT user_id FROM Follow WHERE follower_id =:followerId", nativeQuery = true)
	public List<Integer> findFollowingUsers(@Param("followerId") int followerId);


}
