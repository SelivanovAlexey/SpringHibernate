package com.netcracker.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "vendor_id", nullable = false)
    private int vendorId;

    @Column(name= "customer_id", nullable = false)
    private int customerId;

    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Column(name = "book_qty", nullable = false)
    private int qty;

    @Column(name = "amount", nullable = false)
    private int amount;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Purchase(Date date, int vendorId, int customerId, int bookId, int qty, int amount) {
        this.date = date;
        this.vendorId = vendorId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.qty = qty;
        this.amount = amount;
    }

    public Purchase() {
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", vendorId=" + vendorId +
                ", customerId=" + customerId +
                ", bookId=" + bookId +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
