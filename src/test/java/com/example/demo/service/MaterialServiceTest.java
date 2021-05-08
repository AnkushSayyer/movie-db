package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Material;
import com.example.demo.repository.MaterialRepository;

@ExtendWith(MockitoExtension.class)
class MaterialServiceTest {

	@Mock
	private MaterialRepository materialRepository;
	@Mock
	private RatingService ratingService;
	@InjectMocks
	private MaterialService materialService;

	@BeforeEach
	void setup() {
	}

	@Test
	void getMovieById() {
		Material material = new Material();
		material.setTitle("TestMovie");
		when(materialRepository.findById((long) 1)).thenReturn(Optional.of(material));

		material = materialService.getMovieById((long)1);

		assertEquals("TestMovie", material.getTitle());
	}
}
