package com.devsuperior.movieflix.dto;

import java.util.HashSet;
import java.util.Set;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class MovieDTO {

	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	private Long genreId;
	private String genreName;

	private Set<Review> reviews = new HashSet<>();

	public MovieDTO() {

	}

	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.subTitle = movie.getSubTitle();
		this.year = movie.getYear();
		this.imgUrl = movie.getImgUrl();
		this.synopsis = movie.getSynopsis();
		this.genreId = movie.getGenre().getId();
		this.genreName = movie.getGenre().getName();
	}
	
	public MovieDTO(Movie movie, Set<Review> reviews) {
		this(movie);
		this.reviews.addAll(reviews);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	
	

}
