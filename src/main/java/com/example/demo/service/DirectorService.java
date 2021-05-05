package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Director;
import com.example.demo.model.DirectorDTO;
import com.example.demo.repository.DirectorRepository;
import com.example.demo.repository.MaterialRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectorRepository directorRepository;

	@Autowired
	private MaterialRepository materialRepository;

	public Director saveDirector(Director director) {
		return directorRepository.save(director);
	}

	public Director updateDirector(Director director) {
		return directorRepository.save(director);
	}

	public void deleteDirector(Long id) {
		directorRepository.deleteById(id);
	}

	public DirectorDTO getDirectorById(Long id) {
		Director director = directorRepository.findById(id).orElse(null);
		DirectorDTO directorDto = new DirectorDTO();
		directorDto.setId(director.getId());
		directorDto.setName(director.getName());

		directorDto.setMaterials(materialRepository.findByDirector_Id(id));

		return directorDto;
	}
}
