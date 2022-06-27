package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_address_ManyToMany")
public class AddressManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Street", length =50, nullable = false)
    private String street;
    @Column(name="city",length =50, nullable = false)
    private String city;

    @ManyToMany(mappedBy = "addressManyToMany")
    private List<UserManyToMany> userManyToMany;

    public List<UserManyToMany> getUserManyToMany() {
        return userManyToMany;
    }

    public void setUserManyToMany(List<UserManyToMany> userManyToMany) {
        this.userManyToMany = userManyToMany;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
