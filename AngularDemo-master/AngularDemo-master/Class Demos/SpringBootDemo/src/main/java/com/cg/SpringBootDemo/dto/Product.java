package com.cg.SpringBootDemo.dto;

public class Product {

	private int prodId;
	private String prodName;
	private double prodCost;
	private String prodDescription;

	public Product(int prodId, String prodName, double prodCost, String prodDescription) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCost = prodCost;
		this.prodDescription = prodDescription;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdCost() {
		return prodCost;
	}

	public void setProdCost(double prodCost) {
		this.prodCost = prodCost;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + ", prodDescription="
				+ prodDescription + "]";
	}

}
