package com.netcracker.service.bookService;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookService {

    void deleteBook(int id);

    void updateBook(int id, String bookName, int cost, String storage, int amount);

    void addBook(Book book);

    List<Book> showAllBooks();

    int rowCount();

}
