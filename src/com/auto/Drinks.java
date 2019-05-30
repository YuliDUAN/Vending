package com.auto;

public class Drinks {
private String name;
private int price;
private int number;

public Drinks(String name,int price,int number) {
	this.setName(name);
	this.setPrice(price);
	this.setNumber(number);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
}
