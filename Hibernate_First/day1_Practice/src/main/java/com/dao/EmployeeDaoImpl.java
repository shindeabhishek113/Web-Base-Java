package com.dao;
import org.hibernate.*;

import com.pojo.Employee;

import static com.util.HibernateUtils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Override
	public String addEmployee(Employee newEmp) {
		String mesg="12";
		
		Session session = getFactory().openSession();
		
		Transaction tx = session.getTransaction();

		
		try {
			
			Integer id=(Integer) session.save(newEmp);
			mesg = "User regd with ID=" + id;
		}
		catch(RuntimeException e ){
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return mesg;
	}
	
	


}
