package com.wlochynski.fashiongram.dto;

public class PostLikesDTO {
	private int postId;
	private long numberOfLikes;
	
	public PostLikesDTO(int postId, long numberOfLikes) {
		this.postId = postId;
		this.numberOfLikes = numberOfLikes;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public long getNumberOfLikes() {
		return numberOfLikes;
	}
	public void setNumberOfLikes(long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	
	
}
