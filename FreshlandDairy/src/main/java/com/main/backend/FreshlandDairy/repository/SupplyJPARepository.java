package com.main.backend.FreshlandDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.Supply;

@Repository
public interface SupplyJPARepository extends JpaRepository<Supply, Long> {
	List<Supply> findByUsername(String username);

}
