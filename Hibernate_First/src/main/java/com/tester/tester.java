package com.tester;



import static com.util.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.Id;

import org.hibernate.SessionFactory;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.pojo.Department;
import com.pojo.Employee;

public class tester {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			
//			Employee : id (auto_increment : PK) , first name ,
//			last name , department (enum : RND,FINANCE,MARKETING,HR,BILLING), 
//			salary, dob(LocalDate) ,isPermanent(boolean)

			
			Employee emp1 = new Employee(sc.next(), sc.next(), sc.next(), Department.valueOf(sc.next()),
					sc.nextDouble(), LocalDate.parse(sc.next()),sc.nextBoolean());
			
			
			System.out.println("output"+empDao.addEmployee(emp1));
					
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
