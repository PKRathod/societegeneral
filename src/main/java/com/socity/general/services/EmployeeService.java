package com.socity.general.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socity.general.model.Department;
import com.socity.general.model.Employee;
import com.socity.general.repository.DepartmentRepository;
import com.socity.general.repository.EmployeeRepository;
import com.socity.general.util.Base;
import com.socity.general.util.RestException;
import com.socity.general.util.ValidateUtil;

import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository  departmentRepository;
	
	public Base registerEmployee(Employee employee) {
		Base base = new Base();
		try{
			if(employee!=null){
				validateEmployee(employee);
				base.setResponse(employeeRepository.save(employee));
			}else{
				throw new RestException("Rest exception occur..");
			}
		}catch(Exception e){
			log.error("employee registeratio failed..");
			e.printStackTrace();
		}
		return base;
	}

	public void validateEmployee(Employee employee) throws RestException{

		ValidateUtil.notNull(employee.getFirstName());
		ValidateUtil.notNull(employee.getLastName());
		ValidateUtil.notNull(employee.getGender());
		ValidateUtil.notNull(employee.getDateOfBirth());

	}


	public Base getEmployeeList(String firstName){
		Base base = new Base();   
		List<Employee> employeeList = new ArrayList<Employee>();
		try{
			employeeList = employeeRepository.findByFirstName(firstName);
			employeeList.forEach(e->{
				List<Department> dpList = new ArrayList<>();
				if(e.getDepartmentId()!=null){
					Department currentDp =new Department();
					currentDp = departmentRepository.findOne(e.getDepartmentId());
					dpList.add(currentDp);
				}
				e.setDepartmentList(dpList);
			});
			
			
			base.setResponse(employeeList);
		}catch(Exception e){
			log.error("employeelist failed to get..");
			e.printStackTrace();
		}

		return base;
	}


}
