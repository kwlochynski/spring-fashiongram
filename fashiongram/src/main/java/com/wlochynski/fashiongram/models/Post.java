package com.wlochynski.fashiongram.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "photoName")
	private String photoName;
	
	@Column(name = "tshirtUrl")
	private String tshirtUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getTshirtUrl() {
		return tshirtUrl;
	}

	public void setTshirtUrl(String tshirtUrl) {
		this.tshirtUrl = tshirtUrl;
	}
	
	

}
