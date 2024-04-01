package com.alibaba.service.Impl;

import com.alibaba.bean.Customer;
import com.alibaba.bean.response.Response;
import com.alibaba.mapper.CustomerMapper;
import com.alibaba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Response queryCustomerById(String customerId) {

        if (customerId == null || customerId.equals("")) {
            return Response.failed("客户ID不能为空");
        }

        if (customerMapper.queryCustomerById(customerId) == null) {
            return Response.failed("客户不存在");
        }

        return Response.success("success",customerMapper.queryCustomerById(customerId));
    }

    @Override
    public Response queryAllCustomer() {
        if (customerMapper.queryAllCustomer() == null) {
            return Response.failed("无客户信息");
        }
        return Response.success("success",customerMapper.queryAllCustomer());
    }

    @Override
    public Response addCustomer(Customer customer) {
        if (customer == null) {
            return Response.failed("客户信息不能为空");
        }

        if (customerMapper.addCustomer(customer)) {
            return Response.success("success",customer);
        }

        return Response.failed("添加失败");
    }

    @Override
    public Response deleteCustomer(String customerId) {
        if (customerId == null || customerId.equals("")) {
            return Response.failed("客户ID不能为空");
        }

        return customerMapper.deleteCustomer(customerId) ? Response.success("success") : Response.failed("failed");
    }
}
