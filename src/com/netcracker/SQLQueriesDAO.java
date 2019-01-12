package com.netcracker;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service("sqlDAO")
@Transactional
public class SQLQueriesDAO extends BasicDAO {


    /* Task 2 */

    public void getUniqueBooks() {
        Query query = getSession().createQuery("SELECT DISTINCT bookName, cost FROM Book");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            String name = (String) d[0];
            Integer cost = (Integer) d[1];
            System.out.println(name + " " + cost);
        }
    }

    public void getUniqueDistricts() {
        Query query = getSession().createQuery("SELECT DISTINCT district FROM Customer");
        List<Object> data = query.list();
        for (Object d : data) {
            String district = (String) d;
            System.out.println(district);
        }
    }

    public void getUniquePurchaseMonths() {
        Query query = getSession().createQuery("SELECT DISTINCT MONTH(date) FROM Purchase");
        List<Object> data = query.list();
        for (Object d : data) {
            Integer district = (Integer) d;
            System.out.println(district);
        }
    }


    /**/

    /* Task 3 */

    public void getCustomersFromNizhegorodskyDistrict() {
        Criteria criteria = getSession().createCriteria(Customer.class)
                .add(Restrictions.like("district", "Nizhegorodsky"))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("lastName"), "lastName")
                        .add(Projections.property("discount"), "discount"));
        List<Object[]> result = criteria.list();
        for (Object[] row : result) {
            System.out.println(row[0] + " " + row[1]);
        }
    }

    public void getSormovoStores() {
        Criteria criteria = getSession().createCriteria(Store.class)
                .add(Restrictions.like("district", "Sormovo"))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("storeName"), "storeName"));
        List<Object> result = criteria.list();
        for (Object row : result) {
            System.out.println(row);
        }
    }

    public void getWindowsBooks() {
        Criteria criteria = getSession().createCriteria(Book.class)
                .add(Restrictions.or(
                        Restrictions.like("bookName", "%Windows%"),
                        Restrictions.gt("cost", 20000)))
                .addOrder(Order.asc("bookName"))
                .addOrder(Order.desc("cost"))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("bookName"), "bookName")
                        .add(Projections.property("cost"), "cost"));
        List<Object[]> result = criteria.list();
        for (Object[] row : result) {
            System.out.println(row[0] + " " + row[1]);
        }
    }

    /**/

    /* Task 4 */

    public void getShortPurchaseInfo() {
        Query query = getSession().createQuery("SELECT p.orderId, c.lastName, s.storeName " +
                "FROM Customer AS c, Store AS s, Purchase AS p " +
                "WHERE p.customerId = c.id AND p.vendorId = s.id");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            Integer id = (Integer) d[0];
            String name = (String) d[1];
            String store = (String) d[2];
            System.out.println(id + " " + name + " " + store);
        }
    }

    public void getFullPurchaseInfo() {
        Query query = getSession().createQuery("SELECT p.orderId, p.date, c.lastName, c.discount, b.bookName, p.qty " +
                "FROM Customer AS c, Store AS s, Purchase AS p, Book AS b " +
                "WHERE p.customerId = c.id AND p.vendorId = s.id AND p.bookId = b.id");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            Integer id = (Integer) d[0];
            Date date = (Date) d[1];
            String name = (String) d[2];
            Integer discount = (Integer) d[3];
            String book = (String) d[4];
            Integer qty = (Integer) d[5];
            System.out.println(id + " " + date + " " + name + " " + discount + " " + book + " " + qty);
        }
    }

    /**/

    /* Task 5 */

    public void getPurchaseInfoOver60000() {
        Query query = getSession().createQuery("SELECT p.orderId, c.lastName, p.date " +
                "FROM Customer AS c, Store AS s, Purchase AS p " +
                "WHERE p.customerId = c.id AND p.vendorId = s.id AND p.amount > 59999");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            Integer id = (Integer) d[0];
            String name = (String) d[1];
            Date date = (Date) d[2];
            System.out.println(id + " " + name + " " + date);
        }
    }


    public void getPurchasesInCustomersLivingDistrict() {
        Query query = getSession().createQuery("SELECT p.orderId, c.lastName, c.district, p.date " +
                "FROM Customer AS c, Store AS s, Purchase AS p " +
                "WHERE p.customerId = c.id AND p.vendorId = s.id AND " +
                "s.district = c.district AND MONTH(p.date) > 2 ");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            Integer id = (Integer) d[0];
            String name = (String) d[1];
            String district = (String) d[2];
            Date date = (Date) d[3];
            System.out.println(id + " " + name + " " + district + " " + date);
        }
    }

    public void getNotAvtozavodStores() {
        Query query = getSession().createQuery("SELECT s.storeName, s.district " +
                "FROM Customer AS c, Store AS s, Purchase AS p " +
                "WHERE p.customerId = c.id AND p.vendorId = s.id AND " +
                "NOT s.district = 'Avtozavod' AND c.discount >=10 AND c.discount <=15");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            String name = (String) d[0];
            String district = (String) d[1];
            System.out.println(name + " " + district);
        }
    }

    public void getPurchaseBooksInfoInStockOver10(){
        Query query = getSession().createQuery("SELECT b.bookName, b.storage, b.qty, b.cost " +
                "FROM Book AS b, Purchase AS p, Store AS s " +
                "WHERE p.bookId = b.id AND p.vendorId = s.id AND " +
                "b.storage = s.district AND b.qty > 10" +
                "ORDER BY b.bookName ASC");
        List<Object[]> data = query.list();
        for (Object[] d : data) {
            String name = (String) d[0];
            String district = (String) d[1];
            Integer qty = (Integer) d[2];
            Integer cost = (Integer) d[3];
            System.out.println(name + " " + district + " " + qty + " " + cost);
        }
    }

    /**/

}
