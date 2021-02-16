package com.purplepizza.postscrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.purplepizza.postscrud.dto.SocialMediaPostsDTO;
import com.purplepizza.postscrud.entities.SocialMediaPosts;
import com.purplepizza.postscrud.repositories.SocialMediaPostsRepository;

@Service
public class SocialMediaPostsService {

	@Autowired
	private SocialMediaPostsRepository repository;
	
	@Transactional(readOnly = true)
	public SocialMediaPostsDTO findById(Long id) {
		Optional<SocialMediaPosts> obj = repository.findById(id);
		SocialMediaPosts posts = obj.orElseThrow();
		return new SocialMediaPostsDTO(posts);
	}
}
