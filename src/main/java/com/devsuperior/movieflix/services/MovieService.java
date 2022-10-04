package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public MovieDTO findById(Long id) {
		Movie movie = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(movie);
	}
	
	public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable){
		Genre genre = new Genre();
		genre.setId(genreId);
		return repository.findByGenre(genre, pageable);
	}

	public Page<MovieDTO> findAll(Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title").ascending());
		return repository.findAll(pageable).map(obj -> new MovieDTO(obj));
	}

}
