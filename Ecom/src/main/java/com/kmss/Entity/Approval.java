package com.kmss.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Approval")
public class Approval {
	@Id
	@Column(name = "aid")
	private int aid;
	@Column(name="id")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private double price;
	@Column(name =  "STATUS")
	private String status;
	
	public Approval() {
		super();
	}
	public Approval(int id, String name, Double price, String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public int getaid() {
		return aid;
	}
	public void setaid(int aid) {
		this.aid=aid;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
