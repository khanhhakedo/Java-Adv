package com.vti.Dto;

import com.vti.entity.Account;
import com.vti.entity.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProductDto {

    private  Integer id;

    private String productName;

    private Float price;

    private String type;

    private Category category;

    private List<Account> accounts;
}
