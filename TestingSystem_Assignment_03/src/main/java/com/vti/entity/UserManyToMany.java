package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user_ManyToMany")
public class UserManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="UserName", length =50, nullable = false)
    private String userName;

    @ManyToMany
    @JoinTable(
            name = "UserAddress",
            joinColumns ={ @JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="address_id")}
    )
    private List<AddressManyToMany> addressManyToMany;

    public List<AddressManyToMany> getAddress() {

        return addressManyToMany;
    }

    public void setAddress(List<AddressManyToMany> addressManyToMany) {
        this.addressManyToMany = addressManyToMany;
    }



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

    @Override
    public String toString() {
        return "UserManyToMany{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", addressManyToMany=" + addressManyToMany +
                '}';
    }

    public String toStringNotAddress() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
