package com.purplepizza.postscrud.dto;

import java.io.Serializable;

public class SocialMediaPostsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String posts;
	private String imgURL;
	
	public SocialMediaPostsDTO() {
	}

	public SocialMediaPostsDTO(Long id, String posts, String imgURL) {
		this.id = id;
		this.posts = posts;
		this.imgURL = imgURL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosts() {
		return posts;
	}

	public void setPosts(String posts) {
		this.posts = posts;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

}
