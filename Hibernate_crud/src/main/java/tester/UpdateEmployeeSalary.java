package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class UpdateEmployeeSalary {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("Enter emp details : firstName,  lastName, increase salary,Department ");
			System.out.println(empDao.updateEmp(sc.next(), sc.next(), sc.nextDouble(),Department.valueOf(sc.next())));
		}

	}

}
