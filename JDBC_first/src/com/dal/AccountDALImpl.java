package com.dal;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.pojo.*;

import com.util.DBUtil;

public class AccountDALImpl implements BankDAL {

	private Connection con;
	private Statement stmt;
	private CallableStatement cstmt;
	private PreparedStatement pstmt1, pstmt2, pstmt3;
	private ResultSet rset;
	

	
	
	  public AccountDALImpl() throws SQLException {
		  con=DBUtil.getCon();
		  stmt=con.createStatement();
		  
		  pstmt1=con.prepareStatement("INSERT INTO bankaccount VALUES(?,?,?,?)");
		  pstmt2=con.prepareStatement("UPDATE bankaccount SET name=?, type=? WHERE id=?");
		  pstmt3=con.prepareStatement("DELETE FROM bankaccount WHERE id=?");
		  
		  System.out.println("---account dal created----"); 
	}
	
	

	
	
	
	@Override
	public List<Account> showAllAccounts() throws SQLException{
		
		List<Account> list = new ArrayList<>();
		
		rset=stmt.executeQuery("select * from bankaccount");
		
		while(rset.next()) {
			
			list.add(new Account(rset.getInt("id"),
					rset.getString("name"),
					rset.getString("type"),
					rset.getDouble("balance")));
		}
		return list;	
	}


	@Override
	public int addNewAccount(Account obj) throws SQLException {
		pstmt1.setInt(1, obj.getId());
		pstmt1.setString(2, obj.getName());
		pstmt1.setString(3, obj.getType());
		pstmt1.setDouble(4, obj.getBalance());
		
		int i=pstmt1.executeUpdate();
		System.out.println("---inserted obj:"+obj);
		return i;
	}


	@Override
	public int updateAccount(Account obj) throws Exception {
		pstmt2.setString(1, obj.getName());
		pstmt2.setString(2, obj.getType());
		pstmt2.setInt(3, obj.getId());
		
		int i=pstmt2.executeUpdate();
		System.out.println("---Updated obj:"+obj);
		return i;
	}


	@Override
	public int deleteAccount(int id) throws Exception {
		pstmt3.setInt(1, id);
		
		int i=pstmt3.executeUpdate();
		System.out.println("---Deleted ID:"+id);
		return i;
	}


	@Override
	public double depositeMoney(int id, double amount) throws Exception {
		
		cstmt=con.prepareCall("{call deposite(?,?,?)}");
		
		cstmt.setInt(1, id);//1st IN parameter
		cstmt.setDouble(2, amount);//2nd IN parameter
		
		cstmt.registerOutParameter(3, Types.DOUBLE);
		
		
		cstmt.execute();
		return cstmt.getDouble(3);
	}


	@Override
	public double withdrawMoney(int id, double amount) throws Exception {
		cstmt=con.prepareCall("{call withdraw(?,?,?)}");
		
		cstmt.setInt(1, id);//1st IN parameter
		cstmt.setDouble(2, amount);//2nd IN parameter
		
		cstmt.registerOutParameter(3, Types.DOUBLE);
		
		
		cstmt.execute();
		return cstmt.getDouble(3);
	}
	
	
	@Override
	public String moneyTransfer(int sId, int rId, double amount) throws SQLException {

		cstmt=con.prepareCall("{call transfer_funds(?,?,?,?,?)}"); 
		
		//In parameter
		cstmt.setInt(1, sId);//1st IN parameter
		cstmt.setInt(2, rId);//2nd IN parameter
		cstmt.setDouble(3, amount);//3rd IN parameter
		
	
		//out parameter
		cstmt.registerOutParameter(4, Types.DOUBLE);//parameter 4 data type is double JVM send this info to DB
		cstmt.registerOutParameter(5, Types.DOUBLE);//parameter 5
		
		
		//execute Stored Procedure
		cstmt.execute();		
		
		return  "Money Transfer : Sender Balance="+cstmt.getDouble(4)+"   Reciver Balance:"+cstmt.getDouble(5);
	}

	
}
