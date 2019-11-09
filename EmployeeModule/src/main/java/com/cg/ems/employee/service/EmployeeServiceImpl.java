package com.cg.ems.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;
import com.cg.ems.employee.repo.EmployeeRepo;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Employee addEmployee(Employee employee) throws EmployeeNotFoundException{
		if(repo.searchEmployee(employee.getEmpId()) == null) 
			return repo.save(employee);
		else
			throw new EmployeeNotFoundException("Employee with id "+employee.getEmpId()+" already exists.");
	}

	@Override
	public Employee searchEmployee(String empId) throws EmployeeNotFoundException {
		if(repo.searchEmployee(empId) == null) 
			throw new EmployeeNotFoundException("Employee with id "+empId+"not found.");
		else
			return repo.searchEmployee(empId);
	}
	
	@Override
	public List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException {
		if(repo.searchDesignation(designation) == null) 
			throw new EmployeeNotFoundException("Employee with designation "+designation+"not found.");
		else
			return repo.searchDesignation(designation);
	}
	@Override
	public List<Employee> searchDomain(String domain) throws EmployeeNotFoundException {
		if(repo.searchDomain(domain) == null) 
			throw new EmployeeNotFoundException("Employee with domain "+domain+"not found.");
		else
			return repo.searchDomain(domain);
	}
	@Override
	public List<Employee> listEmployee() throws EmployeeNotFoundException {
		if(repo.listEmployee() == null)
			throw new EmployeeNotFoundException("Employees not found.");
		else
			return repo.listEmployee();
	}

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

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Employee emp = repo.searchEmployee(employee.getEmpId());
		if(emp == null) 
			throw new EmployeeNotFoundException("Employee with id "+employee.getEmpId()+" already exists.");
		else {
			employee.setAccountNumber(emp.getAccountNumber());
			employee.setBankName(emp.getBankName());
			employee.setPassword(emp.getPassword());
			return repo.save(employee);
		}
	}

	/*
	 * @Override public Employee modifyEmployee(Employee employee) throws
	 * EmployeeNotFoundException { if(repo.modifyEmployee(employee) == null) throw
	 * new EmployeeNotFoundException("Employee with id "+employee.getEmpId()
	 * +"could not be modified."); else return repo.modifyEmployee(employee); }
	 */

	
	 @Override 
	 public String changePassword(String empid, String oldPassword, String newPassword) throws EmployeeNotFoundException, PasswordNotMatchedException { 
		 Employee employee = repo.searchEmployee(empid);
		 if(employee == null)
			 throw new EmployeeNotFoundException("Employee not present. Password could not be changed."); 
		 else {
			 if(employee.getPassword().equals(oldPassword)) {
				 employee.setPassword(newPassword);
				 return repo.save(employee).getEmpId();
			 }else {
				 throw new PasswordNotMatchedException("Old Password entered does not match. Password not changed."); 
			 }
		 }
	 }

	@Override
	public String addBankDetails(String empId, String bankName, String accountNo) throws EmployeeNotFoundException {
		Employee employee = repo.searchEmployee(empId);
		 if(employee == null)
			 throw new EmployeeNotFoundException("Employee not present. Bank details could not be added."); 
		 else {
			 employee.setBankName(bankName);
			 employee.setAccountNumber(accountNo);
			 return repo.save(employee).getEmpId();
			 //throw new PasswordNotMatchedException("Old Password entered does not match. Password not changed."); 
			 
		 }
	}

	@Override
	public Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException {
		Employee employee = repo.loginEmployee(empId, password);
		 if(employee == null)
			 throw new EmployeeNotFoundException("Employee not present. Login denied."); 
		 else 
			 return employee;
		 
	}
	 

}
