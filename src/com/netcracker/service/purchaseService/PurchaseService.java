package com.netcracker.service.purchaseService;

import com.netcracker.dao.purchaseDAO.IPurchaseDAO;
import com.netcracker.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService {

    @Autowired
    IPurchaseDAO purchaseDAO;

    @Override
    public void deletePurchase(int id) {
        purchaseDAO.deletePurchase(id);
    }

    @Override
    public void updatePurchase(int id, Date date, int vendorId, int customerId, int bookId, int qty, int amount) {
        purchaseDAO.updatePurchase(id,date,vendorId,customerId,bookId,qty,amount);
    }


    @Override
    public void addPurchase(Purchase purchase) {
        purchaseDAO.addPurchase(purchase);
    }

    @Override
    public List<Purchase> showAllPurchases() {
        return purchaseDAO.showAllPurchases();
    }

    @Override
    public int rowCount() {
        return purchaseDAO.rowCount();
    }
}
