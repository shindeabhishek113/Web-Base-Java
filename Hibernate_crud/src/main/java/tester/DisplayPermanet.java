package tester;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;

public class DisplayPermanet 
{

	public static void main(String[] args) 
	{
		
		try (SessionFactory sf = getFactory()) 
		{

			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			dao.permanentEmp().forEach(e -> System.out.println("Id: "+e.getEmpId()+", FirstName: "+e.getFirstName()+", LastName: "+e.getLastName()+", Salary"+e.getSalary()));

		}//try
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}//catch
		
	}//main
}//class
