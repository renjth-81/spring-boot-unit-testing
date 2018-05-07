package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class ControllerTests {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Test
	public void testAdd() throws Exception {
		when(this.employeeService.get(Mockito.anyInt())).thenReturn(getEmployeeDto());
		this.mvc.perform(get("/update").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk()).andExpect(content().string("updated"));
	}
	
	private EmployeeDto getEmployeeDto() {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setAge(23);
		employeeDto.setName("testEmployee");
		employeeDto.setId(1);
		return employeeDto;
	}

}
