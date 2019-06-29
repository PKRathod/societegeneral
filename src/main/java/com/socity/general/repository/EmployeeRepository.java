package com.socity.general.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socity.general.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

	@Query(nativeQuery=false, name="SELECT * FROM Employee ORDER BY firstName ASC")
	List<Employee> findByFirstName(String firstName);
	
	
}
