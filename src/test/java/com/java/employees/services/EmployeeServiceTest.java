package com.java.employees.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.employees.dao.EmployeeRepository;
import com.java.employees.model.Employee;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository employeeRepository;
	
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindEmp() {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Ram", "Singh"));
		
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		
		List<Employee> list= employeeService.findAll();
		assertEquals(1, list.size());
		Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	void testSaveEmp() {
		Employee employee =new Employee("Ram", "Singh");
		employeeService.save(employee);
		Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
	}

}
