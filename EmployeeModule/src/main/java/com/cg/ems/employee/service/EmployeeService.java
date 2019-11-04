package com.cg.ems.employee.service;

import java.util.List;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee) throws EmployeeNotFoundException;
	
	Employee searchEmployee(String empId) throws EmployeeNotFoundException;
	
	List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException;
	
	List<Employee> searchDomain(String domain) throws EmployeeNotFoundException;
	
	List<Employee> listEmployee() throws EmployeeNotFoundException;
	
	boolean deleteById(String empId) throws EmployeeNotFoundException;

	Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	
	//Employee modifyEmployee(Employee employee) throws EmployeeNotFoundException;
	
	String changePassword(String empid, String oldPassword, String newPassword) throws EmployeeNotFoundException, PasswordNotMatchedException;

	String addBankDetails(String empId, String bankName, String accountNo) throws EmployeeNotFoundException;

	Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException;
	
}
