package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	public Rating saveRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	public Rating updateRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	public void deleteRating(Long id) {
		ratingRepository.deleteById(id);
	}

	public void updateRating(Long ratingId, double rate) {
		Rating rating = ratingRepository.findById(ratingId).get();
		Double newRating = ((rating.getRating()*rating.getUsers())+rate)/(rating.getUsers()+1);
		rating.setRating(newRating);
		rating.setUsers(rating.getUsers()+1);

		saveRating(rating);
	}

	public Rating createRating() {
		Rating rating = new Rating();
		rating = ratingRepository.save(rating);
		return rating;
	}
}
