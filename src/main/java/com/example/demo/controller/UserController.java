package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Domain;
import com.example.demo.model.DomainType;
import com.example.demo.model.Rate;
import com.example.demo.model.Rated;
import com.example.demo.model.User;
import com.example.demo.service.RateService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RateService rateService;

	@PostMapping("/signup")
	public Long signup(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PostMapping("/login")
	public void login(@RequestBody User user) {

	}

	@PostMapping("{userId}/title/{titleId}/rate")
	@PreAuthorize("hasRole('USER')")
	public void rate(@PathVariable Long userId, @PathVariable Long titleId, @RequestBody Rate rate) {
		rateService.rate(userId, titleId, rate);
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("{userId}/watchlist")
	public List<Domain> getWatchList(@PathVariable Long userId){
		return userService.getWatchList(userId);
	}

	@PostMapping("{userId}/watchlist/add/{titleId}")
	@PreAuthorize("hasRole('USER')")
	public void addToWatchList(@PathVariable Long userId, @PathVariable Long titleId, @RequestParam DomainType type){
		userService.addToWatchList(userId, titleId, type);
	}

	@GetMapping("{userId}/rated")
	@PreAuthorize("hasRole('USER')")
	public List<Rated> ratedBy(@PathVariable Long userId) {
		return userService.ratedByUser(userId);
	}
}
