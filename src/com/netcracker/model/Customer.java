package com.netcracker.model;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name="discount", nullable = false)
    private int discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Customer(String lastName, String district, int discount) {
        this.lastName = lastName;
        this.district = district;
        this.discount = discount;
    }



    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", district='" + district + '\'' +
                ", discount=" + discount +
                '}';
    }
}
