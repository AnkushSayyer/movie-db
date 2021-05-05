package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Brand;
import com.example.demo.model.DomainType;
import com.example.demo.model.Rating;
import com.example.demo.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private RatingService ratingService;

	public Long saveBrand(Brand brand) {
		Rating rating = ratingService.createRating();
		brand.setRating(rating);
		brand.setType(DomainType.BRAND);
		return brandRepository.save(brand).getId();
	}
}
