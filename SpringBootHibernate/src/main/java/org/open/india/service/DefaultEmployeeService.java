package org.open.india.service;

import org.open.india.model.Employee;
import org.open.india.repository.HibernateEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Autowired
	private HibernateEmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

}
