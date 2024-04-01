package com.alibaba.controller;

import com.alibaba.bean.Customer;
import com.alibaba.bean.response.Response;
import com.alibaba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicinalPSS/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerServiceImpl;


    @RequestMapping("/queryAll")
    public Response queryAll() {
        return customerServiceImpl.queryAllCustomer();
    }

    @RequestMapping("/queryById")
    public Response queryById(String customerId) {
        return customerServiceImpl.queryCustomerById(customerId);
    }

    @RequestMapping("/deleteCustomer")
    public Response deleteCustomer(String customerId) {
        return customerServiceImpl.deleteCustomer(customerId);
    }

    @RequestMapping("/addOneCustomer")
    public Response addOneCustomer(Customer customer) {
        return customerServiceImpl.addCustomer(customer);
    }


}
