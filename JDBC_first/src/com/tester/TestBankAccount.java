package com.tester;

import java.sql.SQLException;
import com.pojo.*;
import java.util.*;
import java.util.Scanner;

import com.dal.AccountDALImpl;
import com.util.DBUtil;

public class TestBankAccount {

	public static void main(String[] args) {
		int choice=1;
		
		try(Scanner sc = new Scanner(System.in)) {
			
			DBUtil.openConnection();
			AccountDALImpl adi = new AccountDALImpl();


			while(choice<8 && choice>0) {
				
			System.out.println("\nEnter Your Choice\r\n"
					+ "1.Show All Accounts\r\n"
					+ "2:Add New Account\r\n"
					+ "3:Update/Edit Account\r\n"
					+ "4:Delete Account\r\n"
					+ "5:Deposite\r\n"
					+ "6:Withdraw\r\n"
					+ "7:Transfer Money");
			
			choice=sc.nextInt();
				
			switch(choice)
			{
			case 1: // Display all accounts
				List<Account> account = adi.showAllAccounts();
				account.forEach(actt->System.out.println(actt));
				break;
				
			case 2: //Add account
				System.out.println("Enter Account Id, Name, Type, Initial Balance respectively: ");
				Account accInsert = new Account(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
				System.out.println("Number of account inserted is: "+adi.addNewAccount(accInsert));
				break;
				
			case 3: //Update account
				System.out.println("Enter Account Id, Name, Type respectively: ");
				Account accUpdate = new Account(sc.nextInt(),sc.next(),sc.next());
				System.out.println("Number of account Updated is: "+adi.updateAccount(accUpdate));
				break;
				
			case 4://Delete account
				System.out.println("Enter Account Id: ");
				System.out.println("Number of account Deleted is: "+adi.deleteAccount(sc.nextInt()));
				break;
				
			case 5://Deposit Amount
				System.out.println("Enter Account Id & Amount: ");
				System.out.println("Updated account balance is: "+adi.depositeMoney(sc.nextInt(),sc.nextDouble()));
				break;
				
			case 6://Withdraw Amount
				System.out.println("Enter Account Id & Amount: ");
				System.out.println("Updated account balance is: "+adi.withdrawMoney(sc.nextInt(),sc.nextDouble()));
				break;
				
			case 7://Transfer Funds
				System.out.println("Enter Account Id of Sender & Reciever then Amount Respectively: ");
				System.out.println(adi.moneyTransfer(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
				break;
				
			} //end of switch
			
		}//end of while
			
		}//end of try 
		catch (Exception e) {
			e.printStackTrace();
		}//end of catch 

	}//end of main

}//end of class