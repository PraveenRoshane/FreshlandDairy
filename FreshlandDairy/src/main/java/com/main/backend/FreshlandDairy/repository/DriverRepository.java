package com.main.backend.FreshlandDairy.repository;

import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.Driver;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long>{

}
