package com.example.MovieSpace;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



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
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner movieDemo(RestTemplate restTemplate, MovieRepository movieRepository, UserRepository userRepository) {
		return (args) -> {
			
			
			//get top rated movies from API and save it to String variable
			String result = restTemplate.getForObject("https://api.themoviedb.org/3/movie/top_rated?api_key=2c006bb2980db62983eba1d45daf8fb1", String.class);
			//log.info(quote.toString());
			
			JSONObject jsonResult1 = new JSONObject(result);
			
			JSONArray jsonResult2 = jsonResult1.getJSONArray("results");
			
			//getting results of object within an array from API
			for(int i=0; i < jsonResult2.length(); i++ ) {
				JSONObject jsonMovie = jsonResult2.getJSONObject(i);
				
				int dbID = jsonMovie.getInt("id");
				String title= jsonMovie.getString("title");
				String year= jsonMovie.getString("release_date");
				double rating = jsonMovie.getDouble("vote_average");
				String poster = "https://image.tmdb.org/t/p/w200" + jsonMovie.getString("poster_path");
				movieRepository.save(new Movie(dbID, title, year, rating, poster));
				
								
			}
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			/*			
			log.info("fetch all movies");
			for (Movie movie : movieRepository.findAll() ) {
				log.info(movie.toString());
			}*/
		};
		
	}	
}
