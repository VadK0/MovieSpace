package com.example.MovieSpace.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LikedMovieRepository extends CrudRepository<LikedMovie, Long>{

	List<LikedMovie> findByTitle(String title);
	
}
