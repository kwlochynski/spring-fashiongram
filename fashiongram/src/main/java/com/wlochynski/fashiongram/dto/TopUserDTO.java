package com.wlochynski.fashiongram.dto;

public class TopUserDTO {
	private int userId;
	private String name;
	private String avatarUrl;
	private long numberOfFollowers;
	
	
    public TopUserDTO(int userId, String name, String avatarUrl, long numberOfFollowers) {
        this.userId = userId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.numberOfFollowers = numberOfFollowers;
    }
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public long getNumberOfFollowers() {
		return numberOfFollowers;
	}

	public void setNumberOfFollowers(long numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}

	
	
}
