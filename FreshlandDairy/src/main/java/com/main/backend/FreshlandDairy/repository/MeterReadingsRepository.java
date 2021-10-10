package com.main.backend.FreshlandDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.MeterReading;

@Repository
public interface MeterReadingsRepository extends JpaRepository<MeterReading, Long>  {

}
