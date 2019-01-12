package com.netcracker.dao.storeDAO;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Book;
import com.netcracker.model.Store;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("storeDAO")
@Transactional
public class StoreDAOImpl extends BasicDAO implements IStoreDAO {
    @Override
    public void deleteStore(int id) {
        Query query = getSession().createQuery("DELETE FROM store WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateStore(int id, String newStoreName, String newDistrict, int newCommission) {
        Criteria criteria = getSession().createCriteria(Store.class);
        criteria.add(Restrictions.eq("id",id));
        Store store = (Store) criteria.uniqueResult();
        store.setStoreName(newStoreName);
        store.setDistrict(newDistrict);
        store.setCommission(newCommission);
        update(store);
    }

    @Override
    public void addStore(Store store) {
        persist(store);
    }

    @Override
    public List<Store> showAllStores() {
        Criteria criteria = getSession().createCriteria(Store.class);
        return criteria.list();
    }

    @Override
    public int rowCount() {
        Criteria criteria = getSession().createCriteria(Store.class);
        return criteria.list().size()-1;
    }
}
