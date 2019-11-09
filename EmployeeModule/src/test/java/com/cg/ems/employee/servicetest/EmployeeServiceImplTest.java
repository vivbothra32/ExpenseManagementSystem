/**
 * 
 */
package com.cg.ems.employee.servicetest;

import static org.junit.Assert.*;

import java.awt.List;
import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

/**
 * @author admin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	@Mock 
	private EmployeeService service;
	private MockMvc mockMvc;
	@Spy
	@InjectMocks
	private RestController controller = new RestController() {
		
		@Override
		public Class<? extends Annotation> annotationType() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String value() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#addEmployee(com.cg.ems.employee.dto.Employee)}.
	 * @throws Exception 
	 */
	@Test
	public void testAddEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId("EE46005");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		employee.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(employee);
		//Mockito.when(service.add(Mockito.any(Employee.class))).thenReturn(false);
		
		Mockito.when(service.addEmployee(Mockito.any(Employee.class)));
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/add").content(jsonString)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(404)).andReturn();
		assertEquals(404, result.getResponse().getStatus());
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchEmployee(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSearchEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId("EE46005");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		employee.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		Mockito.when(service.searchEmployee(Mockito.anyString())).thenReturn(employee);
		mockMvc.perform(MockMvcRequestBuilders.get("/id/EE46005")).andExpect(MockMvcResultMatchers.status().is(404));
		//.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("EE46005"));
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchDesignation(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSearchDesignation() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId("EE46005");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		employee.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		
		Employee employee1 = new Employee();
		employee1.setEmpId("EE46006");
		employee1.setName("Anurag Singh");
		employee1.setPan("CEOPB658R");
		employee1.setDomain("Angular");
		employee1.setDesignation("Senior Analyst");
		employee1.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee1.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee1.setSalary(50214);
		employee1.setBankName("Axis Bank");
		employee1.setAccountNumber("4187004242");
		employee1.setBalance(20000);
		employee1.setPassword("qwerty123");
		employee1.setViewStatus(true);
		
		java.util.List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		employees.add(employee1);
		Mockito.when(service.searchDomain(Mockito.anyString())).thenReturn(employees);
		mockMvc.perform(MockMvcRequestBuilders.get("/domain/Cloud")).andExpect(MockMvcResultMatchers.status().is(404));
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchDomain(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSearchDomain() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId("EE46005");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		employee.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		
		Employee employee1 = new Employee();
		employee1.setEmpId("EE46006");
		employee1.setName("Anurag Singh");
		employee1.setPan("CEOPB658R");
		employee1.setDomain("Angular");
		employee1.setDesignation("Senior Analyst");
		employee1.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee1.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee1.setSalary(50214);
		employee1.setBankName("Axis Bank");
		employee1.setAccountNumber("4187004242");
		employee1.setBalance(20000);
		employee1.setPassword("qwerty123");
		employee1.setViewStatus(true);
		
		java.util.List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		employees.add(employee1);
		Mockito.when(service.searchDomain(Mockito.anyString())).thenReturn(employees);
		mockMvc.perform(MockMvcRequestBuilders.get("/domain/Cloud")).andExpect(MockMvcResultMatchers.status().is(404));
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#listEmployee()}.
	 * @throws Exception 
	 */
	@Test
	public void testListEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setEmpId("EE46005");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		employee.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		
		Employee employee1 = new Employee();
		employee1.setEmpId("EE46006");
		employee1.setName("Anurag Singh");
		employee1.setPan("CEOPB658R");
		employee1.setDomain("Angular");
		employee1.setDesignation("Senior Analyst");
		employee1.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee1.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee1.setSalary(50214);
		employee1.setBankName("Axis Bank");
		employee1.setAccountNumber("4187004242");
		employee1.setBalance(20000);
		employee1.setPassword("qwerty123");
		employee1.setViewStatus(true);
		
		java.util.List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		employees.add(employee1);
		Mockito.when(service.searchDomain(Mockito.anyString())).thenReturn(employees);
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/")).andExpect(MockMvcResultMatchers.status().is(200));
		
		
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#deleteById(java.lang.String)}.
	 */
	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#updateEmployee(com.cg.ems.employee.dto.Employee)}.
	 */
	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#changePassword(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testChangePassword() throws Exception {
		Employee employee1 = new Employee();
		employee1.setEmpId("EE46006");
		employee1.setName("Anurag Singh");
		employee1.setPan("CEOPB658R");
		employee1.setDomain("Angular");
		employee1.setDesignation("Senior Analyst");
		employee1.setDateOfJoining(new SimpleDateFormat("dd-MM-yyyy").parse("13-08-2019"));
		employee1.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse("11-04-1997"));
		employee1.setSalary(50214);
		employee1.setBankName("Axis Bank");
		employee1.setAccountNumber("4187004242");
		employee1.setBalance(20000);
		employee1.setPassword("qwerty123");
		employee1.setViewStatus(true);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(employee1);
		Mockito.when(service.searchEmployee(Mockito.anyString())).thenReturn(employee1);
		
		//((EmployeeService) Mockito.when(service)).updateEmployee(Mockito.any(Employee.class));
		mockMvc.perform(
				MockMvcRequestBuilders.put("/update").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#addBankDetails(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddBankDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#loginEmployee(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLoginEmployee() {
		fail("Not yet implemented");
	}

}
