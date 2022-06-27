package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user_ManyToOne")
public class UserManyToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="UserName", length =50, nullable = false)
    private String userName;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressManyToOne addressManyToOne;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AddressManyToOne getAddressManyToOne() {
        return addressManyToOne;
    }

    public void setAddressManyToOne(AddressManyToOne addressManyToOne) {
        this.addressManyToOne = addressManyToOne;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address=" + addressManyToOne +
                '}';
    }


    public String toStringNotAddress() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
