package com.netcracker.dao.customerDAO;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerDAO {

    void deleteCustomer(int id);

    void updateCustomer(int id, String newLastName, String newDistrict, int newDiscount);

    void addCustomer(Customer customer);

    List<Customer> showAllCustomers();

    int rowCount();
}
