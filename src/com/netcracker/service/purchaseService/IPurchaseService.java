package com.netcracker.service.purchaseService;

import com.netcracker.model.Purchase;

import java.util.Date;
import java.util.List;

public interface IPurchaseService {

    void deletePurchase(int id);

    void updatePurchase(int id, Date date, int vendorId, int customerId, int bookId, int qty, int amount);

    void addPurchase(Purchase purchase);

    List<Purchase> showAllPurchases();

    int rowCount();
}
