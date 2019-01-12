package com.netcracker.service.customerService;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerService {

    void deleteCustomer(int id);

    void updateCustomer(int id, String lastName, String district, int discount);

    void addCustomer(Customer customer);

    List<Customer> showAllCustomers();

    int rowCount();
}
