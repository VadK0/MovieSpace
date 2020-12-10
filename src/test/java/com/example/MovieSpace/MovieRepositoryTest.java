package com.example.MovieSpace;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.MovieSpace.domain.Movie;
import com.example.MovieSpace.domain.MovieRepository;




@DataJpaTest
public class MovieRepositoryTest {
	@Autowired
    private MovieRepository repository;
	
	@Test
    public void findByTitleShouldReturnMovie() {
        List<Movie> movies = repository.findByTitle("Gabriel's Inferno Part III");
        
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getYear()).isEqualTo("2020-11-19");
    }
    
    @Test
    public void createNewMovie() {
    	Movie movie = new Movie(0101, "Ernest Doni", "1930",  5, "poster");
    	repository.save(movie);
    	assertThat(movie.getId()).isNotNull();
    }
}
