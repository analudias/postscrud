package com.purplepizza.postscrud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<SocialMediaPostsDTO>> findAll() {
		List<SocialMediaPostsDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<SocialMediaPostsDTO> insert(@RequestBody SocialMediaPostsDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SocialMediaPostsDTO> update(@PathVariable Long id, @RequestBody SocialMediaPostsDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SocialMediaPostsDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
