package com.netcracker.dao.storeDAO;

import com.netcracker.model.Store;

import java.util.List;

public interface IStoreDAO {

    void deleteStore(int id);

    void updateStore(int id, String newStoreName, String newDistrict, int newCommission);

    void addStore(Store store);

    List<Store> showAllStores();

    int rowCount();
}
