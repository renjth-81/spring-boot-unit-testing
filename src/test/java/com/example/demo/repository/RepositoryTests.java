package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void testAdd(){
		employeeRepository.save(getEmployee());
		Employee employee = employeeRepository.findByName("Turing");
		assertEquals("Turing", employee.getName());
		assertEquals(32, employee.getAge());
	}
	
	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setAge(32);
		employee.setName("Turing");
		return employee;
	}
	
}
