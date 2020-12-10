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
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private int dbID;
	private String title;
	private String year;
	private double rating;
	/*private String duration;
	
	@ManyToOne
    @JoinColumn(name = "genId")
	@JsonBackReference
	private Genre genre;
	 */
	public Movie() {}
	
	public Movie(int dbID, String title, String year, double rating) {
		super();
		this.dbID = dbID;
		this.title = title;
		this.year = year;
		this.rating = rating;
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

	
	
	
}
