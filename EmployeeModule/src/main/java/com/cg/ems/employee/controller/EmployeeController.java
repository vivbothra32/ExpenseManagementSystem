package com.cg.ems.employee.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.AuthenticationManager;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;
import com.cg.ems.employee.service.EmployeeService;


/**
 * Controller class 
 * @author Vivek Bothra
 * @version 1.0
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
	
	//Autowiring the service object
	@Autowired
	private EmployeeService service;
	
	//Logger object for logging various activities
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	/**
	 * Vivek Bothra
	 * Function to add an employee into the database.
	 * @param emp
	 * @return ResponseEntity<Employee> object
	 * @throws EmployeeNotFoundException
	 */
	@PostMapping(value = "/add")
	public  ResponseEntity<?> addEmployee( @ModelAttribute Employee emp) throws EmployeeNotFoundException  {
		logger.info("adding employee");
		Employee temp = emp;

		Employee employee = service.addEmployee(emp);
		if (employee == null) {
			logger.error("Employee not added");
			return new ResponseEntity("Employee Not Added.", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("Employee added");
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		//return service.addEmployee(employee);
	}
	/**
	 * Function to search employee by id.
	 * @param empId
	 * @return Employee
	 */
	@GetMapping(value = "/id/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployee(@PathVariable String empId) {
		logger.info("searching employee by id");
		try {
			logger.info("Employee found");
			return service.searchEmployee(empId);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employee not found");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	/**
	 * Function to display employees of a particular designation
	 * @param designation
	 * @return List<Employee>
	 * @throws EmployeeNotFoundException
	 */
	@GetMapping(value = "/designation/{designation}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchDesigation(@PathVariable String designation)   {
		logger.info("searching employee by designation");
		try {
			logger.info("Employees found");
			return service.searchDesignation(designation);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees not found");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Function to display employees of a particular domain
	 * @param domain
	 * @return List<Employee>
	 * @throws EmployeeNotFoundException
	 */
	@GetMapping(value = "/domain/{domain}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> searchDomain(@PathVariable String domain)   {
		logger.info("searching employee by domain");
		try {
			logger.info("Employees found");
			return service.searchDomain(domain);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees not found");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Function to display list of all employees 
	 * @return List<Employee>
	 * @throws EmployeeNotFoundException
	 */
	@GetMapping(value = "/", produces = "application/json")
	public List<Employee> listEmployee() {
		logger.info("listing all employees");
		try {
			logger.info("Employees found");
			return service.listEmployee();
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees not found");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Function to check login credentials and allow access to other functions.
	 * @param empId
	 * @param password
	 * @return
	 */
	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee loginEmployee(@RequestParam String empId, @RequestParam String password)   {
		logger.info("Trying for Login");
		try {
			logger.info("Successful Employee login");
			return service.loginEmployee(empId, password);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees login not successful ");
			System.out.println(ex.getMessage());
			return null;
		}
	}
	

	/**
	 * Function to update details of employee - pan, designation, domain, salary.
	 * @return ResponseEntity<Employee> object
	 * @throws EmployeeNotFoundException
	 */
	@PutMapping(value = "/update")
	public ResponseEntity<Employee> update(@ModelAttribute Employee employee){
		logger.info("Updating Employee details");
		try {
			Employee emp = service.searchEmployee(employee.getEmpId());
			logger.info("Setting pan, designation, domain and salary in Employee object");
			emp.setPan(employee.getPan());
			emp.setDesignation(employee.getDesignation());
			emp.setDomain(employee.getDomain());
			emp.setSalary(employee.getSalary());
			logger.info("Sent to service for update");
			return new ResponseEntity<Employee>(service.updateDetails(emp), HttpStatus.OK);
			
		} catch (NumberFormatException ex) {
			logger.error("Employees update not successful ");
			return new ResponseEntity("Update failed", HttpStatus.BAD_REQUEST);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees update not successful ");
			return new ResponseEntity("Update failed", HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * Function to change password of Employee. Checks the existing password with entered old password.
	 * If both the passwords match, allows the password change to happen.
	 * @param empId
	 * @param oldPassword
	 * @param newPassword
	 * @return ResponseEntity<Employee> object
	 */
	@GetMapping(value = "/password")
	public ResponseEntity<Employee> changePassword(@RequestParam("empId") String empId, @RequestParam("oldPassword") String oldPassword, 
				@RequestParam("newPassword") String newPassword){
		logger.info("Updating Employee password");
		Employee employee = new Employee();
		try {
			employee = service.searchEmployee(empId);
			if(employee == null) {
				logger.error("Employees password update not successful. Employee not found.");
				throw new EmployeeNotFoundException("Employee not present. Password could not be changed."); 
			}
			 else {
				 if(employee.getPassword().contentEquals(oldPassword)) {
					 System.out.println(oldPassword);
					 System.out.println(employee.getPassword());
					 employee.setPassword(newPassword);
					 Employee emp = service.changePassword(employee);
					 return new ResponseEntity<Employee>(emp, HttpStatus.OK);
				 }else {
					 logger.error("Employees password update not successful ");
					 return new ResponseEntity("Password not changed", HttpStatus.BAD_REQUEST);
				 }
			 }
		} catch (EmployeeNotFoundException e) {
			logger.error("Employees password update not successful ");
			return new ResponseEntity("Password not changed", HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Function to update bank details of the employee - bank name, account number and salary.
	 * @param empId
	 * @param bankName
	 * @param accountNo
	 * @param salary
	 * @return ResponseEntity<Employee> object
	 */
	@GetMapping(value = "/bank")
	public ResponseEntity<Employee> addBankDetails(@RequestParam("empId") String empId, @RequestParam("bankName")
			String bankName, @RequestParam("accountNumber") String accountNo, @RequestParam("salary") String salary){
		logger.info("Updating Employee bank details");
		try {
			Employee emp = service.searchEmployee(empId);
			emp.setAccountNumber(accountNo);
			emp.setBankName(bankName);
			emp.setSalary(Double.parseDouble(salary));
			
			return new ResponseEntity<Employee>(service.addBankDetails(emp), HttpStatus.OK);
		} catch (NumberFormatException ex) {
			logger.error("Employees bank details update not successful ");
			return new ResponseEntity("Employee not present", HttpStatus.BAD_REQUEST);
		} catch (EmployeeNotFoundException ex) {
			logger.error("Employees bank details update not successful ");
			return new ResponseEntity("Employee not present", HttpStatus.BAD_REQUEST);
		}
		
	}
	/**
	 * Function to delete the employee by employee id. Changes the flag of viewStatus to false.
	 * @param empId
	 * @return Employee object
	 * @throws EmployeeNotFoundException
	 */
	@PutMapping(value = "/delete/{empId}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Employee deleteById(@PathVariable String empId)    {
		return deleteById(empId);
		
	}

}
