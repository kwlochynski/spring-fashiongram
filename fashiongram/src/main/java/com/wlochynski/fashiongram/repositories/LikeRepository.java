package com.wlochynski.fashiongram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.fashiongram.dto.PostLikesDTO;
import com.wlochynski.fashiongram.models.Like;

@Transactional
@Repository("likeRepository")
public interface LikeRepository extends JpaRepository<Like, Integer> {
	public int countByPostIdAndUserId(int postId, int userId);

	public void deleteByPostIdAndUserId(int postId, int userId);
	
	@Query("SELECT new com.wlochynski.fashiongram.dto.PostLikesDTO(postId, count(*) as numberOfLikes) FROM Like WHERE postId in :postIds GROUP BY postId")
	public List<PostLikesDTO> getPostLikesDTO(List<Integer> postIds);
	
	@Query("SELECT postId FROM Like WHERE userId =:userId and postId in :postIds" )
	public List<Integer> getUserLikes(@Param("userId") int userId, @Param("postIds") List<Integer> postIds);
}
