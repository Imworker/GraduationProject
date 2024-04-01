package com.alibaba.mapper;


import com.alibaba.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface CustomerMapper {

    @Select(value = "select * from customer where customer_id=#{customerId} and deleted=0")
    Customer queryCustomerById(String customerId);

    @Select(value = "select * from customer where deleted=0")
    List<Customer> queryAllCustomer();

    @Select(value = "insert into customer (customer_id,customer_name,phone,address) values(#{customerId},#{customerName},#{phone},#{address})")
    boolean addCustomer(Customer customer);

    @Select(value = "update customer set deleted=1 where customer_id=#{customerId}")
    boolean deleteCustomer(String customerId);



}
