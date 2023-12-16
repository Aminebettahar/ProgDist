package com.example.RentMotorbikes;

import java.util.ArrayList;
import java.util.List;

public class Motorbike {
	
	private String plateNumber;
	private String brand;
	private int price;
    private boolean rented;
    private List<Dates> historique = new ArrayList<Dates>();

    public List<Dates> getHistorique() {
        return historique;
    }

    public void setHistorique(Dates date) {
        this.historique.add(date);
    }

	
	public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Motorbike() {
		super();
	}
	
	public Motorbike(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Motorbike [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}