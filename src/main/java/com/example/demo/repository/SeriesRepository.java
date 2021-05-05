package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {

}
