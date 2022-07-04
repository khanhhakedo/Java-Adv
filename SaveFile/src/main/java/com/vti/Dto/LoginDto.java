package com.vti.Dto;

import lombok.Data;

@Data
public class LoginDto {
	private int id;
	private String fullname;

	public LoginDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
