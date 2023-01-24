package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface EmployeeDao {
//add a method to save emp details
	String addEmpDetails(Employee newEmp);

	// add a method to list emps from a specific dept n earning sal > specific sal
	List<Employee> getEmpsByDeptAndSalary(Department dept, double minSal);
	
//	Transfer emp to a new department n salary raise, having 
//	specified first name n last name
	
	//update emp dept;
	
	String updateEmp(String fn, String ln, double sal, Department dept);
	
	List<Employee> permanentEmp();
	
	String deleteEmplyeeTemp();
}
