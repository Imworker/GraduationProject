package com.alibaba.controller;

import com.alibaba.bean.Supplier;
import com.alibaba.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicinalPSS/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierServiceImpl;

    @RequestMapping("/queryAll")
    public Object queryAll() {
        return supplierServiceImpl.queryAllSupplier();
    }

    @RequestMapping("/queryById")
    public Object queryById(String supplierId) {
        return supplierServiceImpl.querySupplierById(supplierId);
    }

    @RequestMapping("/deleteSupplier")
    public Object deleteSupplier(String supplierId) {
        return supplierServiceImpl.deleteSupplier(supplierId);
    }

    @RequestMapping("/addOneSupplier")
    public Object addOneSupplier(Supplier supplier) {
        return supplierServiceImpl.addSupplier(supplier);
    }





}
