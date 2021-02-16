package com.purplepizza.postscrud.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purplepizza.postscrud.dto.SocialMediaPostsDTO;
import com.purplepizza.postscrud.services.SocialMediaPostsService;

@RestController
@RequestMapping(path = "/posts")
public class SocialMediaPostsResource {
	
	@Autowired
	private SocialMediaPostsService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SocialMediaPostsDTO> findById(@PathVariable Long id) {
		SocialMediaPostsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

}
