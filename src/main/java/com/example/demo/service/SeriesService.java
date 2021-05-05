package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DomainType;
import com.example.demo.model.Rating;
import com.example.demo.model.Series;
import com.example.demo.repository.SeriesRepository;

@Service
public class SeriesService {
	@Autowired
	private SeriesRepository brandSeries;

	@Autowired
	private RatingService ratingService;

	public Long saveSeries(Series series) {
		Rating rating = ratingService.createRating();
		series.setRating(rating);
		series.setType(DomainType.SERIES);
		return brandSeries.save(series).getId();
	}
}
