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

import com.example.demo.model.Director;
import com.example.demo.model.DirectorDTO;
import com.example.demo.service.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {

	@Autowired
	private DirectorService directorService;

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String saveDirector(@RequestBody Director director) {
		Director savedDirector = directorService.saveDirector(director);
		return savedDirector != null ? savedDirector.getId().toString() : "failed";
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String updateDirector(@RequestBody Director director) {
		Director savedDirector = directorService.saveDirector(director);
		return savedDirector != null ? "success" : "failed";
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteDirector(@PathVariable Long id) {
		directorService.deleteDirector(id);
		return null;
	}

	@GetMapping("/{id}")
	public DirectorDTO getDirectorById(@PathVariable Long id) {
		return directorService.getDirectorById(id);
	}
}
