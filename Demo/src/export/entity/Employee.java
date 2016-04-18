package export.entity;

import java.util.Date;

public class Employee {
	private int id;
	private String name;
	private Date time;
	private double salary;
	
	public Employee(int id, String name, Date time, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
