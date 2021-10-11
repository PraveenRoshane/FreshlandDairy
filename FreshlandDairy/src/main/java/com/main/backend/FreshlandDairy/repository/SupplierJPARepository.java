package com.main.backend.FreshlandDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.Supplier;

@Repository
public interface SupplierJPARepository extends JpaRepository<Supplier, Long> {
	List<Supplier> findByUsername(String username);

}
