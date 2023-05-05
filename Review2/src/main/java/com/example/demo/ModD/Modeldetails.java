package com.example.demo.ModD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="details")
public class Modeldetails {
	@Id
	private int id;
	private String name;
	private int price;
	private int rating;
	private int calories;
	private String item_name;
	private String cusine;
	private String type;
	private String meal;
	private String addons;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getCusine() {
		return cusine;
	}
	public void setCusine(String cusine) {
		this.cusine = cusine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getAddons() {
		return addons;
	}
	public void setAddons(String addons) {
		this.addons = addons;
	}
	@Override
	public String toString() {
		return "Modeldetails [id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + ", calories="
				+ calories + ", item_name=" + item_name + ", cusine=" + cusine + ", type=" + type + ", meal=" + meal
				+ ", addons=" + addons + "]";
	}
	
	
	
}