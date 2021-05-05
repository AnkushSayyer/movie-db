package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rate;
import com.example.demo.model.User;
import com.example.demo.repository.RateRepository;

@Service
public class RateService {

	@Autowired
	private RatingService ratingService;

	@Autowired
	private RateRepository rateRepository;

	public void rate(Long userId, Long titleId, Rate rate) {
		User user = new User();
		user.setId(userId);
		rate.setUser(user);
		rate.setTitleId(titleId);
		rateRepository.save(rate);

		ratingService.updateRating(rate.getRating().getId(), rate.getRate());
	}

	public List<Rate> ratedByuser(Long userId) {
		return rateRepository.findByUser_Id(userId);
	}

}
