package com.vti.form;

import lombok.Data;

@Data
public class AccountFormForCreating {
	private String email;
	private String username;
	private String fullname;
	private String password;
	private String address;
	private Integer productId;


	public AccountFormForCreating() {
		super();
		// TODO Auto-generated constructor stub
	}

}
