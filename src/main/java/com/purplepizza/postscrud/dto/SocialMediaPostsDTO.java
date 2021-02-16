package com.purplepizza.postscrud.dto;

import java.io.Serializable;

import com.purplepizza.postscrud.entities.SocialMediaPosts;

public class SocialMediaPostsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String posts;
	private String imgUrl;
	
	public SocialMediaPostsDTO() {
	}

	public SocialMediaPostsDTO(Long id, String posts, String imgUrl) {
		this.id = id;
		this.posts = posts;
		this.imgUrl = imgUrl;
	}
	
	public SocialMediaPostsDTO(SocialMediaPosts entity) {
		id = entity.getId();
		posts = entity.getPost();
		imgUrl = entity.getImgUrl();
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
		return imgUrl;
	}

	public void setImgURL(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
