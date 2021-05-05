//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Rating;
//import com.example.demo.service.RatingService;
//
//@RestController
//@RequestMapping("/rating")
//public class RatingController {
//
//	@Autowired
//	private RatingService ratingService;
//
//	@PostMapping
//	public String saveRating(@RequestBody Rating rating) {
//		Rating savedRating = ratingService.saveRating(rating);
//		return savedRating != null ? savedRating.getId().toString() : "failed";
//	}
//
//	@PutMapping
//	public String updateRating(@RequestBody Rating rating) {
//		Rating savedRating = ratingService.saveRating(rating);
//		return savedRating != null ? "success" : "failed";
//	}
//
//	@DeleteMapping("/{id}")
//	public String deleteRating(@PathVariable Long id) {
//		ratingService.deleteRating(id);
//		return null;
//	}
//}
