package com.andredias20.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andredias20.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
