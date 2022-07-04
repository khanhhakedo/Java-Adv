package com.vti.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Account")
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private  Integer id;

    @Column(name = "UserName", nullable = false,length = 50)
    private String userName;

    @Column(name = "FullName", nullable = false, length = 50)
    private String fullname;

    @Column(name = "Password", nullable = false, length = 15)
    private  String password;

    @Column(name = "Email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "Address", nullable = false,length = 100)
    private  String address;

    @ManyToMany
    @JoinTable(
            name = "ProductAccount",
            joinColumns = {@JoinColumn(name = "ProductID")},
            inverseJoinColumns = {@JoinColumn(name = "AccountID")}
    )
    private List<Product> products;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' + "\n"+
                ", fullname='" + fullname + '\'' +"\n"+
                ", password='" + password + '\'' +"\n"+
                ", email='" + email + '\'' +"\n"+
                ", address='" + address + '\'' +"\n"+
                ", products=" + products +"\n"+
                '}';
    }
}

