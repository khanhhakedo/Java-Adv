package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id // tao primakey id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // tu dong tang

    private Integer id;

    @Column(name = "product_name", length = 20, nullable = false, unique = true)
    private String productName;

    private  String price;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @CreationTimestamp
    private  Date updatedDate;

    public Integer getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
