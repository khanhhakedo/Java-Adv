package com.vti.form;

import lombok.Data;

@Data
public class AccountFormForCreatingRegister {
	private String email;
	private String username;
	private String fullname;
	private String password;
	private String address;
	private Integer productId;

	public AccountFormForCreatingRegister() {
		super();
		// TODO Auto-generated constructor stub
	}



}
