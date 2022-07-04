package com.vti.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.entity.Product;
import com.vti.entity.Video;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class CategoryDto {

    private Integer id;

    private String categoryName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    private List<Video> videoList;

    private List<Product> products;
}
