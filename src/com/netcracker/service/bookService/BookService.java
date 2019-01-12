package com.netcracker.service.bookService;


import com.netcracker.dao.bookDAO.IBookDAO;
import com.netcracker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;

    public void deleteBook(int id){
        bookDAO.deleteBook(id);
    }

    @Override
    public void updateBook(int id, String bookName, int cost, String storage, int amount) {
        bookDAO.updateBook(id,bookName,cost,storage,amount);
    }


    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookDAO.showAllBooks();
    }

    @Override
    public int rowCount() {
        return bookDAO.rowCount();
    }

}
