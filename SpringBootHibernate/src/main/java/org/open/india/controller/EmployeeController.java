package org.open.india.controller;

import org.open.india.model.Employee;
import org.open.india.service.DefaultEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private DefaultEmployeeService employeeService;

	@RequestMapping("/")
	public String employee() {
		return "employee";
	}

	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(Employee employee) {
		ModelAndView mv = new ModelAndView("employee");
		employeeService.addEmployee(employee);
		mv.addObject("message", "Employee Added successfully!");
		return mv;
	}
}
