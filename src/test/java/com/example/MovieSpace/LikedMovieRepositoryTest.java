package com.example.MovieSpace;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MovieSpace.domain.LikedMovie;
import com.example.MovieSpace.domain.LikedMovieRepository;


@DataJpaTest
public class LikedMovieRepositoryTest {
	@Autowired
    private LikedMovieRepository repository;
	
	@Test
    public void findByTitleShouldReturnMovie() {
        List<LikedMovie> movies = repository.findByTitle("Gabriel's Inferno Part III");
        
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getYear()).isEqualTo("2020-11-19");
    }
    
    @Test
    public void createNewMovie() {
    	LikedMovie movie = new LikedMovie("Ernest Doni", "1930",  5, "poster");
    	repository.save(movie);
    	assertThat(movie.getId()).isNotNull();
    }
}
