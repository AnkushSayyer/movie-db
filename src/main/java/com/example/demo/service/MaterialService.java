package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NoSeriesException;
import com.example.demo.model.DomainType;
import com.example.demo.model.Material;
import com.example.demo.model.Rating;
import com.example.demo.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private RatingService ratingService;

	public List<Material> getAllMovies(String language, String sortBy) {
		return null;
	}

	public Material saveMovie(Material material) {
		if(material.getType().equals(DomainType.EPISODE) && material.getSeries() == null) {
			throw new NoSeriesException("Add series for episode");
		}
		Rating rating = ratingService.createRating();
		material.setRating(rating);
		return materialRepository.save(material);
	}

	public Material updateMovie(Material material) {
		return materialRepository.save(material);
	}

	public void deleteMovie(Long id) {
		materialRepository.deleteById(id);
	}

	public Material getMovieById(Long id) {
		return materialRepository.findById(id).orElse(null);
	}
}
