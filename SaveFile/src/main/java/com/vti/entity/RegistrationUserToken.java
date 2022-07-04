package com.vti.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Data
@Entity
@Table(name = "`Registration_User_Token`")
public class RegistrationUserToken implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "token", length = 36, nullable = false, unique = true)
	private String token;

	@OneToOne(targetEntity = Account.class)
	@JoinColumn(name = "user_id")
	private Account account;

	@Column(name = "expiryDate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;



}
