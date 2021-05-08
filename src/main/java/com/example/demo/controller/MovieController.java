package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Material;
import com.example.demo.service.MaterialService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MaterialService materialService;

	@GetMapping
	public List<Material> getAllMovies(@RequestParam String language, @RequestParam String sortBy) {
		return materialService.getAllMovies(language, sortBy);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String saveMovie(@RequestBody Material material) {
		try {
			Material savedMaterial = materialService.saveMovie(material);
			return savedMaterial != null ? savedMaterial.getId().toString() : "failed";
		}
		catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Add series for episode");
		}
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String updateMovie(@RequestBody Material material) {
		Material savedMaterial = materialService.saveMovie(material);
		return savedMaterial != null ? "success" : "failed";
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteMovie(@PathVariable Long id) {
		materialService.deleteMovie(id);
		return null;
	}

	@GetMapping("/{id}")
	public Material getMovieById(@PathVariable Long id) {
		return materialService.getMovieById(id);
	}
}
