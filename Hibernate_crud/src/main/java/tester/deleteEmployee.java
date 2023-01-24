package tester;
import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
public class deleteEmployee {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory()){
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println(empDao.deleteEmplyeeTemp());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
