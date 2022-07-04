package com.vti.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ArticleDto {

    private Integer id;

    private String articleName;

    private  String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    private Product product;

}
