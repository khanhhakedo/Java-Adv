package com.vti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID" )
    private  Integer id;

    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;

    @Column(name = "Price", nullable = false)
    private Float price;

    @Column(name = "Type", nullable = false, length = 100)
    private String type;


    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +"\n"+
                ", price=" + price +"\n"+
                ", type='" + type + '\'' +"\n"+
                ", category=" + category +"\n"+
                ", accounts=" + accounts +"\n"+
                '}';
    }
}
