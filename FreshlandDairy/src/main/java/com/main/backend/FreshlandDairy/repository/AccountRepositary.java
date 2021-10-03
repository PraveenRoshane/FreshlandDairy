package com.main.backend.FreshlandDairy.repository;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
 import com.main.backend.FreshlandDairy.entity.*;



public interface AccountRepositary extends JpaRepository<Account, Long>{
	
	@Query(value="SELECT * FROM accounts a  WHERE a.month=?1 OR a.year=?2", nativeQuery = true)
	List<Account> findBydate(String month, Long year);
	
	@Query(value="SELECT * FROM accounts a  WHERE a.account_type=?1 AND a.month=?2 AND a.year=?3", nativeQuery = true)
	List<Account> findBydate(String type, String month, Long year);
	
	
	
	@Query(value="SELECT SUM(a.amount) FROM accounts a  WHERE a.month=?1 OR a.year=?2", nativeQuery = true)
	double getSum(String accountType, Long year);
	
	@Query(value="SELECT SUM(a.amount) FROM accounts a  WHERE a.account_type=?1 AND a.month=?2 AND a.year=?3", nativeQuery = true)
	double getSum(String accountType, String month, Long year);

}
