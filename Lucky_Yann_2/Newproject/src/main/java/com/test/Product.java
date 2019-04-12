package com.test;

public class Product {

	private String name, description, img;
	private int price;


	public Product(String name, String description, String img, int price)
	{	
		this.name=name;
		this.description=description;
		this.img = img;
		this.price=price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: " + this.name + " | Description: "+ this.description + " | Price: "+ this.price;
	}

}