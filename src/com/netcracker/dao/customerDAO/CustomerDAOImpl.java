package com.netcracker.dao.customerDAO;


import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BasicDAO implements ICustomerDAO {
    @Override
    public void deleteCustomer(int id) {
        Query query = getSession().createQuery("DELETE FROM customer WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateCustomer(int id, String newLastName, String newDistrict, int newDiscount) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        Customer customer = (Customer) criteria.uniqueResult();
        customer.setLastName(newLastName);
        customer.setDistrict(newDistrict);
        customer.setDiscount(newDiscount);
        update(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        persist(customer);
    }

    @Override
    public List<Customer> showAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public int rowCount() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list().size()-1;
    }
}
