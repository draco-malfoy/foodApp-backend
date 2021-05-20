package com.mt.FoodApp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ngo")
public class NGO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String address;

	@Column(name = "pin_code")
	private int pinCode;

	@Column(name = "phone_number")
	@Pattern(regexp = "[0-9]{10}", message = "Phone number should be 10 digit long and excluding any prefixes")
	private String phoneNumber;

	private String city;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Set<Order> orders;

	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Set<Item> items;

	public NGO() {
		super();
	}

	public NGO(long id, String name, String address, int pinCode, String phoneNumber, String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.pinCode = pinCode;
		this.phoneNumber = phoneNumber;
		this.city = city;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
