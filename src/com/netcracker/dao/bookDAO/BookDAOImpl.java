package com.netcracker.dao.bookDAO;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BasicDAO implements IBookDAO {

    @Override
    public void deleteBook(int id) {
        Query query = getSession().createQuery("DELETE FROM book WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();

        /*Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        Book book = (Book) criteria.uniqueResult();
        delete(book);*/

    }

    @Override
    public void updateBook(int id, String newBookName, int newCost, String newStorage, int newAmount) {
        Criteria criteria = getSession().createCriteria(Book.class);
        criteria.add(Restrictions.eq("id",id));
        Book book = (Book) criteria.uniqueResult();
        book.setBookName(newBookName);
        book.setCost(newCost);
        book.setStorage(newStorage);
        book.setQty(newAmount);
        update(book);
    }


    @Override
    public void addBook(Book book) {
        persist(book);
    }

    @Override
    public List<Book> showAllBooks() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list();
    }

    @Override
    public int rowCount() {
        Criteria criteria = getSession().createCriteria(Book.class);
        return criteria.list().size()-1;
    }
}
