package com.cg.ems.employee.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;
import com.cg.ems.employee.repo.EmployeeRepo;

/**
 * EmployeeServiceimpl class - Contains business logic of the various CRUD operations.
 * Delegates call to EmployeeRepo where the CRUD operations get implemented.
 * @author Vivek Bothra
 * @version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	//Autowiring EmployeeRepo object
	@Autowired
	private EmployeeRepo repo;
	
	/**
	 * Function to add employee in database - when employee registers.
	 * Delegates the call to EmployeeRepo where the query gets fired to add the employee details to database.
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeNotFoundException{
		if(repo.searchEmployee(employee.getEmpId()) == null) {
			employee.setViewStatus(true);
			return repo.save(employee);
		}
		else
			throw new EmployeeNotFoundException("Employee with id "+employee.getEmpId()+" already exists.");
	}
	
	/**
	 * Function to search employee by id from the database-
	 * delegate the call to EmployeeRepo where search takes place by empId
	 * @param empId
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee searchEmployee(String empId) throws EmployeeNotFoundException {
		if(repo.searchEmployee(empId) == null) 
			throw new EmployeeNotFoundException("Employee with id "+empId+"not found.");
		else
			return repo.searchEmployee(empId);
	}
	/**
	 * Function to search list of employees of particular designation from database
	 * Delegates call to EmployeeRepo where search takes place by designation
	 * @param designation
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException {
		if(repo.searchDesignation(designation) == null) 
			throw new EmployeeNotFoundException("Employee with designation "+designation+"not found.");
		else
			return repo.searchDesignation(designation);
	}
	/**
	 * Function to search list of employees of particular domain from database
	 * Delegates call to EmployeeRepo where search takes place by domain
	 * @param domain
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public List<Employee> searchDomain(String domain) throws EmployeeNotFoundException {
		if(repo.searchDomain(domain) == null) 
			throw new EmployeeNotFoundException("Employee with domain "+domain+"not found.");
		else
			return repo.searchDomain(domain);
	}
	/**
	 * Function to fetch all employees from database whose viewStatus is true
	 * Delegates call to EmployeeRepo where all employees with viiewStatus = 'true' gets fetched
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public List<Employee> listEmployee() throws EmployeeNotFoundException {
		if(repo.listEmployee() == null)
			throw new EmployeeNotFoundException("Employees not found.");
		else
			return repo.listEmployee();
	}
	/**
	 * Function to change viewStatus of employee to false. 
	 * Soft deleting the employee information
	 * @return true/false
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public boolean deleteById(String empId) throws EmployeeNotFoundException {
		Employee employee = repo.searchEmployee(empId);
		if( employee == null)
			throw new EmployeeNotFoundException("Employee to be deleted not found.");
		else {
			employee.setViewStatus(false);
			repo.save(employee);
			return true;
		}
	}
	/**
	 * Function to update employee details - designation, domain , pan, salary
	 * Delegates call to EmployeeRepo where update of pan, designation, domain and salary takes place
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Employee emp = repo.searchEmployee(employee.getEmpId());
		if(emp == null) 
			throw new EmployeeNotFoundException("Employee with id "+employee.getEmpId()+" not found");
		else {
			emp.setDesignation(employee.getDesignation());
			emp.setDomain(employee.getDomain());
			emp.setPan(employee.getPan());
			emp.setSalary(employee.getSalary());
			return repo.save(emp);
		}
	}


	/**
	 *  Function to update employee details - password
	 *  Delegates call to EmployeeRepo where update of password takes place
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee changePassword(Employee employee) {
		return repo.save(employee);
	}
	
	/**
	 *  Function to update employee details - bankName, account number and salary
	 *   Delegates call to EmployeeRepo where update of bank name, account number and salary takes place
	 * @param emp
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee addBankDetails(Employee emp) throws EmployeeNotFoundException {
		
		 if(emp == null)
			 throw new EmployeeNotFoundException("Employee not present. Bank details could not be added."); 
		 else {
			 
			 return repo.save(emp);
			 //throw new PasswordNotMatchedException("Old Password entered does not match. Password not changed."); 
			 
		 }
	}
	

	/**
	 * Function to authenticate user credentials - empId and password.
	 * Delegates call to EmployeeRepo where Employee having the input empId and password gets fetched.
	 * If not found, EmployeeNotFoundException is thrown.
	 * @param empId
	 * @param password
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Override
	public Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException {
		Employee employee = repo.loginEmployee(empId, password);
		 if(employee == null)
			 throw new EmployeeNotFoundException("Employee not present. Login denied."); 
		 else 
			 return employee;
		 
	}
	
	@Override
	public Employee updateDetails(Employee emp) {
		return repo.save(emp);
	}
	 

}
