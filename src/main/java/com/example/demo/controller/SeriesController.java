package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Series;
import com.example.demo.service.SeriesService;

@RestController
@RequestMapping("/series")
public class SeriesController {

	@Autowired
	private SeriesService seriesService;

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Long saveSeries(@RequestBody Series series) {
		return seriesService.saveSeries(series);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String updateSeries(@RequestBody Series series) {
		return null;
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteSeries(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/{id}")
	public Series getSeriesById(@PathVariable Long id) {
		return null;
	}
}
