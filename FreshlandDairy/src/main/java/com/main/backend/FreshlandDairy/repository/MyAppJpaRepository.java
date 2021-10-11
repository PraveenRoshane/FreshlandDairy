package com.main.backend.FreshlandDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.MyApp;

@Repository
public interface MyAppJpaRepository extends JpaRepository<MyApp, Long> {

		List<MyApp> findByUsername(String username);
}
