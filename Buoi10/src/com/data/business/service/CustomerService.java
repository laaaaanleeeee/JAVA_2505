package com.data.business.service;

import com.data.business.dao.CustomerDAO;
import com.data.business.dao.CustomerDAOImpl;
import com.data.business.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    public List<Customer> getListCustomer() {
        return customerDAO.getListCustomer();
    }

    public void deleteCus(int id) {
        customerDAO.deleteCus(id);
    }

    public void updateCus(Customer customer) {
        customerDAO.updateCus(customer);
    }

    public void saveCus(Customer customer) {
        customerDAO.saveNewCus(customer);
    }



    public void show(List<Customer> customers) {
        System.out.println("==== Danh sách khách hàng ====");

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|  Id  |   Customer Name  |   Customer Phone  |   Customer Email |  Customer Address |");
        customers.forEach(customer -> {
            StringBuilder row = new StringBuilder();
            row.append("|  " + customer.getCusId());
            row.append("|  " + customer.getCusName());
            row.append("|  " + customer.getCusPhone());
            row.append("|  " + customer.getCusEmail());
            row.append("|  " + customer.getCusAddress() + "   |");

            System.out.println(row);
        });
        System.out.println("--------------------------------------------------------------------------------------");

    }
}
