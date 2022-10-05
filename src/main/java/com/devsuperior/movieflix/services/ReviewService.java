package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;


	public ReviewDTO save(ReviewDTO dto) {
		Review entity = new Review();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
	
	private void copyDtoToEntity(Review entity, ReviewDTO dto) {
		Movie movie = new Movie();
		movie.setId(dto.getMovieId());
		
		User user = new User();
		user.setId(dto.getUser().getId());
		user.setName(dto.getUser().getName());
		user.setEmail(dto.getUser().getEmail());
		
		entity.setMovie(movie);
		entity.setUser(user);
		entity.setText(dto.getText());
	}


}
