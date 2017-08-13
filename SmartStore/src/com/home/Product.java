package com.home;

import java.util.Date;

public class Product {
	
	private int id;
	private String designation;
	private String family;
	private String barcode;
	private double cost;
	private double selling1;
	private double selling2;
	private double selling3;
	private int amount;
	private int used;
	private int min;
	private Date expiration;
	private String mesure_unit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getSelling1() {
		return selling1;
	}
	public void setSelling1(double selling1) {
		this.selling1 = selling1;
	}
	public double getSelling2() {
		return selling2;
	}
	public void setSelling2(double selling2) {
		this.selling2 = selling2;
	}
	public double getSelling3() {
		return selling3;
	}
	public void setSelling3(double selling3) {
		this.selling3 = selling3;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public String getMesure_unit() {
		return mesure_unit;
	}
	public void setMesure_unit(String mesure_unit) {
		this.mesure_unit = mesure_unit;
	}	
}
