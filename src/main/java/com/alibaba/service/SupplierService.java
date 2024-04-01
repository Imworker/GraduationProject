package com.alibaba.service;

import com.alibaba.bean.Supplier;
import com.alibaba.bean.response.Response;

public interface SupplierService {

    Response querySupplierById(String supplierId);

    Response queryAllSupplier();

    Response addSupplier(Supplier supplier);

    Response deleteSupplier(String supplierId);

}
