package com.vti.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_user_OneToOne")
public class UserOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="UserName", length =50, nullable = false)
    private String userName;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private AddressOneToOne addressOneToOne;

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

    public AddressOneToOne getAddress() {
        return addressOneToOne;
    }

    public void setAddress(AddressOneToOne addressOneToOne) {
        this.addressOneToOne = addressOneToOne;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address=" + addressOneToOne +
                '}';
    }


    public String toStringNotAddress() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
