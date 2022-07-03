package com.vti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Category")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer id;

    @Column(name = "CategoryName", nullable = false, unique = true,length = 50)
    private String categoryName;

    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate")
    private Date createdDate;

    @OneToMany(mappedBy = "categoryVideo")
    private List<Video> videoList;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", createdDate=" + createdDate +
                ", videoList=" + videoList +
                ", products=" + products +
                '}';
    }
}
