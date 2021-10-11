package com.main.backend.FreshlandDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.Attend;

@Repository
public interface AttendJpaRepository extends JpaRepository<Attend, Long> {
		List<Attend> findByUsername(String username);
}
