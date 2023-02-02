package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//JPA annotations
@Entity
@Table(name="emp")
//Lombok annotations lombok not working
//@NoArgsConstructor //=def arg less ctor
//@AllArgsConstructor //all args ctor
//@Getter //all getters
//@Setter //all setters
//@Data// all getters + setters + hashCode + equals + toString
//@ToString(exclude = "password")//toString excluding password//
public class Employee extends BaseEntity {
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	private String location;
	private LocalDate joinDate;
	private double salary;
	
	public Employee() {

		System.out.println("Default COnstructor");
	}
	public Employee(String firstName, String lastName, String email, String password, String location,
			LocalDate joinDate, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.location = location;
		this.joinDate = joinDate;
		this.salary = salary;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//toString excluding password//
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", location="
				+ location + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
