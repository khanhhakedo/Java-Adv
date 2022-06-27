package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_address_OneToOne")
public class AddressOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Street", length =50, nullable = false)
    private String street;
    @Column(name="city",length =50, nullable = false)
    private String city;

    @OneToOne(mappedBy = "addressOneToOne")
    private UserOneToOne userOneToOne;

    public UserOneToOne getUser() {
        return userOneToOne;
    }

    public void setUser(UserOneToOne userOneToOne) {
        this.userOneToOne = userOneToOne;
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
