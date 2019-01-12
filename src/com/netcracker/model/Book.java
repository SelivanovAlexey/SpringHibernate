package com.netcracker.model;


import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name="storage", nullable = false)
    private String storage;

    @Column(name="qty", nullable = false)
    private int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int amount) {
        this.qty = qty;
    }

    public Book(String bookName, int cost, String storage, int qty) {
        this.bookName = bookName;
        this.cost = cost;
        this.storage = storage;
        this.qty = qty;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", cost=" + cost +
                ", storage='" + storage + '\'' +
                ", qty=" + qty +
                '}';
    }
}
