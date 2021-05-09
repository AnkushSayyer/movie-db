package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DomainType;
import com.example.demo.model.Material;

@Repository
public interface MaterialRepository extends PagingAndSortingRepository<Material, Long>{

	List<Material> findByDirector_Id(Long id);

	List<Material> findByLanguageAndType(String Language, DomainType type, Pageable pageable);

	List<Material> findByType(DomainType type, Pageable pageable);
}
