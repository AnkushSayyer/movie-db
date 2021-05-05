package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long>{

	List<Rate> findByUser_Id(Long userId);
}
