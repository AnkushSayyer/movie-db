package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WatchList;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Long> {

	List<WatchList> findByUser_Id(long userId);
}
