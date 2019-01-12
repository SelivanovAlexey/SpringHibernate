package com.netcracker.dao.bookDAO;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookDAO {

    void deleteBook(int id);

    void updateBook(int id, String newBookName, int newCost, String newStorage, int newAmount);

    void addBook(Book book);

    List<Book> showAllBooks();

    int rowCount();
}
