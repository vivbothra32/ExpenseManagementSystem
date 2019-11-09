package com.cg.ems.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;
import com.cg.ems.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee( @RequestBody Employee employee) throws EmployeeNotFoundException  {
		//try {
			//return service.addEmployee(employee);
		//} catch (EmployeeNotFoundException ex) {
			//System.out.println(ex.getMessage());
			//return employee;
		//}
		return service.addEmployee(employee);
	}
	
	@GetMapping(value = "/id/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployee(@PathVariable String empId) throws EmployeeNotFoundException {
		//try {
			return service.searchEmployee(empId);
		//} catch (EmployeeNotFoundException ex) {
			//System.out.println(ex.getMessage());
			//return null;
		//}
	}
	
	@GetMapping(value = "/designation/{designation}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchDesigation(@PathVariable String designation) throws EmployeeNotFoundException {
		//try {
			return service.searchDesignation(designation);
		//} catch (EmployeeNotFoundException ex) {
			//System.out.println(ex.getMessage());
			//return null;
		//}
	}
	@GetMapping(value = "/domain/{domain}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchDomain(@PathVariable String domain) throws EmployeeNotFoundException {
		//try {
			return service.searchDomain(domain);
		//} catch (EmployeeNotFoundException ex) {
			//System.out.println(ex.getMessage());
			//return null;
		//}
	}
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> listEmployee() throws EmployeeNotFoundException{
		//try {
			return service.listEmployee();
		//} catch (EmployeeNotFoundException ex) {
			//System.out.println(ex.getMessage());
			//return null;
		//}
	}
	
	@GetMapping(value = "/login/{empId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee loginEmployee(@PathVariable String empId, @PathVariable String password) throws EmployeeNotFoundException {
		return service.loginEmployee(empId, password);
	}
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		return service.updateEmployee(employee);
	}
	
	@PutMapping(value = "/password/{empId}/{oldPassword}/{newPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String changePassword(@PathVariable String empId, @PathVariable String oldPassword, @PathVariable String newPassword) throws EmployeeNotFoundException, PasswordNotMatchedException {
		return "Employee "+service.changePassword(empId, oldPassword, newPassword)+" password changed.";
	}
	
	@PutMapping(value = "/bank/{empId}/{bankName}/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addBankDetails(@PathVariable String empId, @PathVariable String bankName, @PathVariable String accountNo) throws EmployeeNotFoundException {
		return "Employee "+service.addBankDetails(empId, bankName, accountNo)+" bank details added.";
	}
	
	@PutMapping(value = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE )
	public String deleteById(@PathVariable String empId) throws EmployeeNotFoundException  {
		return "Employee "+empId+ " deleted : "+service.deleteById(empId);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ValidationFailureResponse validationError(MethodArgumentNotValidException ex) {
//	    BindingResult result = ex.getBindingResult();
//	    final List<FieldError> fieldErrors = result.getFieldErrors();
//
//	    return new ValidationFailureResponse((FieldError[])(fieldErrors.toArray(new FieldError[fieldErrors.size()])));
//	}
}
