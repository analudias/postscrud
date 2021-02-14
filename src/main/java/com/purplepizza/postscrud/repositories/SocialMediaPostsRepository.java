package com.purplepizza.postscrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purplepizza.postscrud.entities.SocialMediaPosts;

@Repository
public interface SocialMediaPostsRepository extends JpaRepository<SocialMediaPosts, Long> {

}
