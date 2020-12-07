package com.example.MovieSpace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MovieSpace.domain.GenreRepository;
import com.example.MovieSpace.domain.MovieRepository;

@Controller
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping(value= {"/", "/movielist"})
	public String movieList(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movielist";
		
	}
}
