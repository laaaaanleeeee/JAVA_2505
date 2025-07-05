package com.data.business.dao;

import com.data.business.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getListCustomer();
    int deleteCus(int id);
    int updateCus(Customer customer);
    int saveNewCus(Customer customer);
}
