package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public void add(EmployeeDto dto) {
		Employee employee = new Employee();
		employee.setAge(dto.getAge());
		employee.setName(dto.getName());
		employeeRepository.save(employee);
	}
	
	public EmployeeDto get(int id) {
		Optional<Employee> optional = employeeRepository.findById(1);
		EmployeeDto dto = new EmployeeDto();
		if(optional.isPresent()){
			Employee employee = optional.get();
			dto.setAge(employee.getAge());
			dto.setName(employee.getName());
			dto.setId(employee.getId());
		}
		return dto;
	}

}
