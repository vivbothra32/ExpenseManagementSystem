package com.cg.ems.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;

public interface EmployeeRepo extends JpaRepository<Employee , String>{
	
	
	
	@Query("SELECT emp FROM Employee emp WHERE emp.empId = :empId AND emp.viewStatus = TRUE")
	Employee searchEmployee(String empId) throws EmployeeNotFoundException;
	
	@Query("SELECT emp FROM Employee emp WHERE emp.designation = :designation AND emp.viewStatus = TRUE")
	List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException;
	
	@Query("SELECT emp FROM Employee emp WHERE emp.domain = :domain AND emp.viewStatus = TRUE")
	List<Employee> searchDomain(String domain) throws EmployeeNotFoundException;
	
	@Query("SELECT emp FROM Employee emp WHERE emp.viewStatus = TRUE")
	List<Employee> listEmployee() throws EmployeeNotFoundException;
	
	@Query("DELETE FROM Employee emp WHERE emp.empId = :empId")
	void deleteById(String empId);
	
	@Query("SELECT emp FROM Employee emp WHERE emp.empId = :empId AND emp.password = :password AND emp.viewStatus = TRUE")
	Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException;

	
	//Employee modifyEmployee(Employee employee)throws EmployeeNotFoundException;;
	
	//@Modifying
	//@Query("UPDATE Employee emp SET emp.password = :password WHERE emp.empId = :empid")
	//String changePassword(String empid, String password) throws EmployeeNotFoundException;;

}
