package com.netcracker.service.storeService;

import com.netcracker.model.Store;

import java.util.List;

public interface IStoreService {

    void deleteStore(int id);

    void updateStore(int id, String storeName, String district, int commission);

    void addStore(Store store);

    List<Store> showAllStores();

    int rowCount();
}
