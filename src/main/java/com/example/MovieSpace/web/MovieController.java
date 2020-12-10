package com.example.MovieSpace.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MovieSpace.domain.LikedMovie;
import com.example.MovieSpace.domain.LikedMovieRepository;
import com.example.MovieSpace.domain.Movie;
import com.example.MovieSpace.domain.MovieRepository;


@Controller
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private LikedMovieRepository likedMovieRepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping(value= {"/", "/movielist"})
	public String movieList(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movielist";
	}
	
	@RequestMapping(value="/movies", method = RequestMethod.GET)
	 public @ResponseBody List<Movie> bookListRest() {	
		 return (List<Movie>) movieRepository.findAll();
	 }
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addMovie(@PathVariable("id") Long movieId, Model model) {
		Optional<Movie> likedMovieResult = movieRepository.findById(movieId);
		Movie likedMovie = likedMovieResult.get();
		likedMovieRepository.save(new LikedMovie(likedMovie.getTitle(), likedMovie.getYear(), likedMovie.getRating(), likedMovie.getPoster()));
        return "redirect:../halloffame";
    }
	
	@RequestMapping(value= {"/halloffame"})
	public String hallOfFame(Model model) {
		model.addAttribute("likedmovies", likedMovieRepository.findAll());
		return "halloffame";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
	public String deleteLikedMovie(@PathVariable("id") Long movieId, Model model) {
		likedMovieRepository.deleteById(movieId);
        return "redirect:../halloffame";
    }
}
