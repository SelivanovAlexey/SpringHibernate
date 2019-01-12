package com.netcracker.service.storeService;


import com.netcracker.dao.storeDAO.IStoreDAO;
import com.netcracker.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("storeService")
public class StoreService implements IStoreService {

    @Autowired
    IStoreDAO storeDAO;


    @Override
    public void deleteStore(int id) {
        storeDAO.deleteStore(id);
    }

    @Override
    public void updateStore(int id, String storeName, String district, int commission) {
        storeDAO.updateStore(id,storeName,district,commission);
    }

    @Override
    public void addStore(Store store) {
        storeDAO.addStore(store);
    }

    @Override
    public List<Store> showAllStores() {
        return storeDAO.showAllStores();
    }

    @Override
    public int rowCount() {
        return storeDAO.rowCount();
    }
}
