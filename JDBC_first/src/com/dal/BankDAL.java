package com.dal;
import com.pojo.*;

import java.sql.SQLException;
import java.util.List;

public interface BankDAL {
//CRUD for Accounts
	//Do in Lab
	//insert update delete
	String moneyTransfer(int sId,int rId,double amount) throws SQLException ;
	
	List<Account> showAllAccounts() throws SQLException;
	
	int addNewAccount(Account obj)throws SQLException;
	
	int updateAccount(Account obj) throws Exception;
	
	int deleteAccount(int id)throws Exception;
	
	double depositeMoney(int id,double amount)throws Exception;
	
	double withdrawMoney(int id,double amount)throws Exception;
	
}
