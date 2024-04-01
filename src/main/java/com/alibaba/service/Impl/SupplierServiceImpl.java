package com.alibaba.service.Impl;

import com.alibaba.bean.Supplier;
import com.alibaba.bean.response.Response;
import com.alibaba.mapper.SupplierMapper;
import com.alibaba.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Response querySupplierById(String supplierId) {

        if (supplierId == null || supplierId.equals("")) {
            return Response.failed("供应商ID不能为空");
        }
        if (supplierMapper.querySupplierById(supplierId) == null) {
            return Response.failed("供应商不存在");
        }

        return Response.success("success",supplierMapper.querySupplierById(supplierId));

    }

    @Override
    public Response queryAllSupplier() {
        if (supplierMapper.queryAllSupplier() == null) {
            return Response.failed("无供应商信息");
        }
        return Response.success("success",supplierMapper.queryAllSupplier());
    }

    @Override
    public Response addSupplier(Supplier supplier) {
        if (supplier == null) {
            return Response.failed("供应商信息不能为空");
        }

        if (supplierMapper.addSupplier(supplier)) {
            return Response.success("success",supplier);
        }

        return Response.failed("添加失败");
    }

    @Override
    public Response deleteSupplier(String supplierId) {

        if (supplierId == null || supplierId.equals("")) {
            return Response.failed("供应商ID不能为空");
        }

        return supplierMapper.deleteSupplier(supplierId) ? Response.success("success") : Response.failed("failed");
    }
}
