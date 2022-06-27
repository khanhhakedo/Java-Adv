package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`Address`")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "street", length = 50, nullable = false)
	private String street;

	@Column(name = "city", length = 50, nullable = false)
	private String city;

	@OneToMany(mappedBy = "address")
	private List<UserAddress> userAddresses;

	public Address() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}


	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", street='" + street + '\'' +
				", city='" + city + '\'' +"\n"+
				'}';
	}
}
