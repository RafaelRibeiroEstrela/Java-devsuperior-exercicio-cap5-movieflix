package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class GenreDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	private Set<Movie> movies = new HashSet<>();
	
	public GenreDTO() {
		
	}
	
	public GenreDTO(Genre genre) {
		id = genre.getId();
		name = genre.getName();
	}
	
	public GenreDTO(Genre genre, Set<Movie> movies) {
		this(genre);
		this.movies.addAll(movies);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	
	

}
