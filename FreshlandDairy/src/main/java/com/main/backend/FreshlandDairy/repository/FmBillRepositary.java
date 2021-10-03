package com.main.backend.FreshlandDairy.repository;

//import java.util.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.backend.FreshlandDairy.entity.FmBillDetails;


@Repository
public interface FmBillRepositary extends JpaRepository <FmBillDetails, Long>{

}
