package com.vti.form;

import lombok.Data;

@Data
public class AccountFormForUpdating {

	private String email;
	private String fullname;
	private Integer productId;

	public AccountFormForUpdating() {
		super();
	}


}
