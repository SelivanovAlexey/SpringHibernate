package com.netcracker.service.customerService;

import com.netcracker.dao.customerDAO.ICustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("customerService")
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerDAO customerDAO;


    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(int id, String lastName, String district, int discount) {
        customerDAO.updateCustomer(id,lastName,district,discount);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public List<Customer> showAllCustomers() {
        return customerDAO.showAllCustomers();
    }

    @Override
    public int rowCount() {
        return customerDAO.rowCount();
    }
}
