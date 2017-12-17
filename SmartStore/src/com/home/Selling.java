package com.home;

public class Selling {
	
	private int id;
	private static int gid = 0;
	private Product product;
	private String category;
	private Double price;
	private Double fees;
	
	public Selling(Product product) {
		this.product = product;
		id = gid++;
		product.setSelling(id, this);
	}
	
	public int getId() {
		return this.id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getFees() {
		
		if (product.getCost() == 0.0)
			fees = 0.0;
		else
			fees = ((price-product.getCost())/product.getCost());
		return fees;
	}
	public void delete() {
		product.deleteSelling(id);
	}
}
