package com.netcracker.dao.purchaseDAO;

import com.netcracker.model.Purchase;

import java.util.Date;
import java.util.List;

public interface IPurchaseDAO {

    void deletePurchase(int id);

    void updatePurchase(int id, Date newDate, int newVendorId, int newCustomerId, int newBookId, int newQty, int newAmount);

    void addPurchase(Purchase purchase);

    List<Purchase> showAllPurchases();

    int rowCount();
}
