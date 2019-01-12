package com.netcracker.model;

import javax.persistence.*;

@Entity
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name="commission", nullable = false)
    private int commission;

    public Store(String storeName, String district, int commission) {
        this.storeName = storeName;
        this.district = district;
        this.commission = commission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public Store() {
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", district='" + district + '\'' +
                ", commission=" + commission +
                '}';
    }
}
