package com.pavan.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pavan.model.CustomerBO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerBO, Long> {
	@Query("select count(c) from CustomerBO c where c.status = ?1")
	public int countByStatus(String Status);
}
