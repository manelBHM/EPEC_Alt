package org.openup.model;

public class Item {
	
	private Dvd dvd;
	private int quntity;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Item(Dvd dvd, int quntity) {
		super();
		this.dvd = dvd;
		this.quntity = quntity;
	}


	public Dvd getDvd() {
		return dvd;
	}
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}


	@Override
	public String toString() {
		return "Item [dvd=" + dvd + ", quntity=" + quntity + "]";
	}
	

}
