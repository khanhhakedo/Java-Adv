package com.vti.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {

    private Integer id;
    private String email;
    private String username;
    private String fullname;
    private String address;
    private String password;
    private String product;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date createDate;

    public AccountDto() {
        super();
        // TODO Auto-generated constructor stub
    }
}
