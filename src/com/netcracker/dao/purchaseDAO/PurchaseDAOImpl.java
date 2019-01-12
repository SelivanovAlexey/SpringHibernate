package com.netcracker.dao.purchaseDAO;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BasicDAO implements IPurchaseDAO {


    @Override
    public void deletePurchase(int id) {
        Query query = getSession().createQuery("DELETE FROM purchase WHERE order_id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updatePurchase(int orderId, Date newDate, int newVendorId, int newCustomerId, int newBookId, int newQty, int newAmount) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("order_id",orderId));
        Purchase purchase = (Purchase) criteria.uniqueResult();
        purchase.setDate(newDate);
        purchase.setVendorId(newVendorId);
        purchase.setCustomerId(newCustomerId);
        purchase.setBookId(newBookId);
        purchase.setQty(newQty);
        purchase.setAmount(newAmount);
        update(purchase);
    }

    @Override
    public void addPurchase(Purchase purchase) {
        persist(purchase);
    }

    @Override
    public List<Purchase> showAllPurchases() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list();
    }

    @Override
    public int rowCount() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list().size()-1;
    }
}
