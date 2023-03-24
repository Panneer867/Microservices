package com.micro.services.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.services.model.Employee;
import com.micro.services.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class HomeController {
	
	@Autowired(required=true)
	private EmployeeService employeeService;

	@GetMapping("/abc")
	public String home() {
		return "Hi Welcome";
	}

	//@RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping("/user")
	public Employee user() {
		Employee user = new Employee();
		user.setEmail("panneer867@gamil.com");
		user.setName("Panneer");
		user.setId("1");
		
		return user;
	}
	
	@GetMapping("/{id}/{id2}")
	public String pathVariable(@PathVariable String id, @PathVariable("id2") String name) {
		
		return "The Path Varible is " + id + " : "+ name; 
	}
	
	@GetMapping("/requestParam")
	public String requestParam(@RequestParam("id") String id, @RequestParam(name = "id2", required = false, defaultValue= "ppppppp") String name ) {
		
		return "The Request Param is " + id + " : "+ name; 
	}

	@PostMapping("/postuser")
	public List<Employee> post(@RequestBody Employee user) {
		return employeeService.postEmploye(user);
	}
	
	@GetMapping("/getuser/{id}")
	public Employee get(@PathVariable String id) {
		return employeeService.getEmploye(id);
	}
	
	
	@DeleteMapping("/del/{id}")
	public String del(@PathVariable String id) {
		return employeeService.delEmpById(id);
	}
}
