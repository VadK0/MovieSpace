package com.example.MovieSpace.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.MovieSpace.domain.Movie;
import com.example.MovieSpace.domain.MovieRepository;


@Controller
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	

	
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
}
