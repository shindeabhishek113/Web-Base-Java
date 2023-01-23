package com.pojo;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="emp")
public class Employee {
	
//	Employee : id (auto_increment : PK) , first name ,
//	last name , department (enum : RND,FINANCE,MARKETING,HR,BILLING), 
//	salary, dob(LocalDate) ,isPermanent(boolean)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name" , length=20)
	
	private String firstName;
	
	@Column(name="last_name",length=20)
	
	private String lastName;
	@Column(length=35,unique=true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Department dept;
	@Column(nullable = false)
	private double salary;
	private LocalDate dob;
	@Column(name="is_permanent")
	
	private boolean isPermanent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public boolean isPermanent() {
		return isPermanent;
	}
	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dept=" + dept + ", salary=" + salary + ", dob=" + dob + ", isPermanent=" + isPermanent + "]";
	}
	public Employee(String firstName, String lastName, String email, Department dept, double salary, LocalDate dob,
			boolean isPermanent) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dept = dept;
		this.salary = salary;
		this.dob = dob;
		this.isPermanent = isPermanent;
	}
	
	
	
	
	
	

}
