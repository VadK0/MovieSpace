 package com.example.MovieSpace.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Movie { //maid class with movies
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int dbID;
	private String title;
	private String year;
	private double rating;
	private String poster;
	
	public Movie() {}
	
	public Movie(int dbID, String title, String year, double rating, String poster) {
		super();
		this.dbID = dbID;
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.poster = poster;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDbID() {
		return dbID;
	}

	public void setDbID(int dbID) {
		this.dbID = dbID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	
	
	
}
