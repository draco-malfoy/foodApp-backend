package com.mt.FoodApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 3, message = "Minimum length of Item name should be 3 characters")
	private String name;

	private String description;

	private double price;

	@Column(name = "food_type")
	private String foodType;

	@Min(value = 1, message = "Minimum rating should be '1'")
	@Max(value = 5, message = "Maximum rating should be '5'")
	private int rating;

	@Column(name = "picture_url")
	private String pictureUrl;

	public Item() {
		super();
	}

	public Item(String name, String description, double price, String foodType, @Min(1) @Max(5) int rating,
			String pictureUrl) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.foodType = foodType;
		this.rating = rating;
		this.pictureUrl = pictureUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
