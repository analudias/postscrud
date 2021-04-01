package com.purplepizza.postscrud.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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

	@Transactional(readOnly = true)
	public List<SocialMediaPostsDTO> findAll() {
		List<SocialMediaPosts> list = repository.findAll();
		return list.stream().map(x -> new SocialMediaPostsDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public SocialMediaPostsDTO insert(SocialMediaPostsDTO dto) {
		SocialMediaPosts posts = new SocialMediaPosts();
		posts.setPost(dto.getPosts());
		posts.setImgUrl(dto.getImgURL());
		posts = repository.save(posts);
		return new SocialMediaPostsDTO(posts);
	}

	@Transactional
	public SocialMediaPostsDTO update(Long id, SocialMediaPostsDTO dto) {
		try {
			SocialMediaPosts entity = repository.getOne(id);
			entity.setImgUrl(dto.getImgURL());
			entity.setPost(dto.getPosts());
			entity = repository.save(entity);
			return new SocialMediaPostsDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found: " + id);
		}
	}
	
	
}
