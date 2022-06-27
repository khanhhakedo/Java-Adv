package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "UserAddress")
public class UserAddress  {



	@EmbeddedId
	private UserAddressKey id;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("address_id")
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "registered_at")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date registeredAt;

	public UserAddress() {
	}

	public UserAddressKey getId() {
		return id;
	}

	public void setId(UserAddressKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	@Override
	public String toString() {
		return "UserAddress{" +
				", registeredAt=" + registeredAt + "\n"+
				'}' + "--";
	}

	@Embeddable
	public static class UserAddressKey implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "user_id", nullable = false)
		private int userId;

		@Column(name = "address_id", nullable = false)
		private int addressId;

		public UserAddressKey() {
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}


	}
}
