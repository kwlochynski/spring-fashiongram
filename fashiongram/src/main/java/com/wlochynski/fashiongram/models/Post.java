package com.wlochynski.fashiongram.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(name = "pantsUrl")
	private String pantsUrl;
	
	@Column(name = "longSleeveUrl")
	private String longSleeveUrl;
	
	@Column(name = "shoesUrl")
	private String shoesUrl;
	
	@Column(name = "others1Url")
	private String others1Url;
	
	@Column(name = "others2Url")
	private String others2Url;
	
	@Column(name = "others3Url")
	private String others3Url;
	
	@Transient
	private String postedUserAvatar;

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

	public String getPantsUrl() {
		return pantsUrl;
	}

	public void setPantsUrl(String pantsUrl) {
		this.pantsUrl = pantsUrl;
	}

	public String getLongSleeveUrl() {
		return longSleeveUrl;
	}

	public void setLongSleeveUrl(String longSleeveUrl) {
		this.longSleeveUrl = longSleeveUrl;
	}

	public String getShoesUrl() {
		return shoesUrl;
	}

	public void setShoesUrl(String shoesUrl) {
		this.shoesUrl = shoesUrl;
	}

	public String getOthers1Url() {
		return others1Url;
	}

	public void setOthers1Url(String others1Url) {
		this.others1Url = others1Url;
	}

	public String getOthers2Url() {
		return others2Url;
	}

	public void setOthers2Url(String others2Url) {
		this.others2Url = others2Url;
	}

	public String getOthers3Url() {
		return others3Url;
	}

	public void setOthers3Url(String others3Url) {
		this.others3Url = others3Url;
	}

	public String getPostedUserAvatar() {
		return postedUserAvatar;
	}

	public void setPostedUserAvatar(String postedUserAvatar) {
		this.postedUserAvatar = postedUserAvatar;
	}
	
	

}
