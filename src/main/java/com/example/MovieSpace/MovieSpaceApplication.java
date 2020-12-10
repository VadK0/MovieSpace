package com.example.MovieSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MovieSpace.domain.Genre;
import com.example.MovieSpace.domain.GenreRepository;
import com.example.MovieSpace.domain.Movie;
import com.example.MovieSpace.domain.MovieRepository;
import com.example.MovieSpace.domain.User;
import com.example.MovieSpace.domain.UserRepository;



@SpringBootApplication
public class MovieSpaceApplication {
	private static final Logger log = LoggerFactory.getLogger(MovieSpaceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MovieSpaceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository movieRepository, GenreRepository genreRepository, UserRepository userRepository) {
		return (args) -> {
			//add genres
			genreRepository.save(new Genre("Drama"));
			genreRepository.save(new Genre("Comedy"));
			genreRepository.save(new Genre("Action"));
			genreRepository.save(new Genre("Crime"));
			
			//add movies
			movieRepository.save(new Movie("The Shawshank Redemption", 1994, 16, 9.3, "2h 22min", genreRepository.findByName("Drama").get(0)));
			movieRepository.save(new Movie("The Godfather", 1972, 16, 9.2, "2h 55min", genreRepository.findByName("Crime").get(0)));
			movieRepository.save(new Movie("The Dark Knight", 2008, 14, 9.0, "2h 32min", genreRepository.findByName("Action").get(0)));
			movieRepository.save(new Movie("Pulp Fiction", 1994, 18, 8.9, "2h 34min", genreRepository.findByName("Crime").get(0)));
		
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
						
			log.info("fetch all books");
			for (Movie movie : movieRepository.findAll() ) {
				log.info(movie.toString());
			}
		};
		
	}	
}
