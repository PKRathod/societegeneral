package com.socity.general.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.socity.general.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>  {
	
}
