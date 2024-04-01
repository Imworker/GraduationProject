package com.alibaba.service;


import com.alibaba.bean.Customer;
import com.alibaba.bean.response.Response;

public interface CustomerService {

    Response queryCustomerById(String customerId);

    Response queryAllCustomer();

    Response addCustomer(Customer customer);

    Response deleteCustomer(String customerId);


}
