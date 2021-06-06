package com.example.rest.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.restfulwebservices.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
