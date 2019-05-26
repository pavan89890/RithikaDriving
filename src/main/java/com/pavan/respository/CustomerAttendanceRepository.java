package com.pavan.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.model.CustomerAttendanceBO;
import com.pavan.model.CustomerBO;

@Repository
public interface CustomerAttendanceRepository extends JpaRepository<CustomerAttendanceBO, Long> {
	public List<CustomerAttendanceBO> findByCustomer(CustomerBO customer);
}
