package com.socity.general.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Setter @Getter
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;

	@NotNull
	private String firstName;

	private String lastName;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender=Gender.MALE;

	private Date dateOfBirth;
	
	@Column(unique=true)
	private Long departmentId;
	
	@Transient
	private List<Department> departmentList;
	


}
