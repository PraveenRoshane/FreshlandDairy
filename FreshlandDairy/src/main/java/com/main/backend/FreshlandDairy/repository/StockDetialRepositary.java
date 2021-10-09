package com.main.backend.FreshlandDairy.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.StockDetails;


@Repository
public interface StockDetialRepositary extends JpaRepository <StockDetails, Long> {
	
	@Query(value = "SELECT * FROM stockdetails WHERE date LIKE %?1%", nativeQuery = true) 
	List<StockDetails> findBySearchTerm(String searchTerm);
}
