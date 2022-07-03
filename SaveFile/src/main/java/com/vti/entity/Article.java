package com.vti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Article")
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArticleID" )
    private Integer id;

    @Column(name = " ArticleName", nullable = false, unique = true,length = 50)
    private String articleName;

    @Column(name="Content", nullable = false,length = 50)
    private  String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate")
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private  Product product;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleName='" + articleName + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", product=" + product +
                '}';
    }
}
