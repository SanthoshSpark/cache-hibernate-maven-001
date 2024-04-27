package com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long id;
	
	@Column(name = "customer_name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "credit_limit", nullable = false)
	private double creditLimit;
	
	@Column(name = "bill_amount", nullable = false)
	private double billAmount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long id, String name, String address, double creditLimit, double billAmount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.creditLimit = creditLimit;
		this.billAmount = billAmount;
	}

	public Customer(String name, String address, double creditLimit, double billAmount) {
		super();
		this.name = name;
		this.address = address;
		this.creditLimit = creditLimit;
		this.billAmount = billAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Customer [ id : " + id + ", name : " + name + ", address : " + address + ", creditLimit : "
				+ creditLimit + ", billAmount : " + billAmount + "]";
	}
	
}
