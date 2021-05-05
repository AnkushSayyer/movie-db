package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Domain;
import com.example.demo.model.DomainType;
import com.example.demo.model.Rate;
import com.example.demo.model.Rated;
import com.example.demo.model.User;
import com.example.demo.model.WatchList;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.SeriesRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WatchListRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WatchListRepository watchListRepository;

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private SeriesRepository seriesRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private RateService rateService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Long saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user).getId();
	}

	public void rate(Long userId, Long titleId, Rate rate) {
		rateService.rate(userId, titleId, rate);
	}

	public void addToWatchList(Long userId, Long titleId, DomainType type) {
		WatchList addToWatchList = new WatchList();
		addToWatchList.setTitleId(titleId);
		User user = new User();
		user.setId(userId);
		addToWatchList.setUser(user);
		addToWatchList.setType(type);
		watchListRepository.save(addToWatchList);
	}

	public List<Domain> getWatchList(long userId) {
		List<WatchList> addedToWatchList = watchListRepository.findByUser_Id(userId);

		return createWatchList(addedToWatchList);
	}

	private List<Domain> createWatchList(List<WatchList> addedToWatchList) {
		List<Domain> watchList = new ArrayList<>();

		for(WatchList toWatch : addedToWatchList) {
			watchList.add(getDomain(toWatch.getTitleId(), toWatch.getType()));
		}

		return watchList;
	}

	public List<Rated> ratedByUser(Long userId) {
		List<Rated> ratedByUser = new ArrayList<>();
		List<Rate> ratingsByUser = rateService.ratedByuser(userId);

		for(Rate rate : ratingsByUser) {
			ratedByUser.add(new Rated(getDomain(rate.getTitleId(), rate.getType()), rate.getRate()));
		}
		return ratedByUser;
	}

	private Domain getDomain(Long id, DomainType type) {
		if(type == DomainType.MOVIE ||type == DomainType.SERIES)
			return materialRepository.findById(id).get();
		else if(type == DomainType.SERIES)
			return seriesRepository.findById(id).get();
		else if(type == DomainType.BRAND)
			return brandRepository.findById(id).get();

		return null;
	}
}
