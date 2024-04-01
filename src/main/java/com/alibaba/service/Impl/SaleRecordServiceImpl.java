package com.alibaba.service.Impl;

import com.alibaba.bean.SaleRecord;
import com.alibaba.bean.response.Response;
import com.alibaba.mapper.SaleRecordMapper;
import com.alibaba.service.SaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleRecordServiceImpl implements SaleRecordService {

    @Autowired
    private SaleRecordMapper saleRecordMapper;

    @Override
    public Response querySaleRecordBySaleNo(String saleNo) {
        if (saleNo == null || saleNo.equals("")) {
            return Response.failed("销售单号不能为空");
        }

        if (saleRecordMapper.querySaleRecordBySaleNo(saleNo) == null) {
            return Response.failed("销售单不存在");
        }

        return Response.success("success", saleRecordMapper.querySaleRecordBySaleNo(saleNo));
    }

    @Override
    public Response queryAllSaleRecord() {
        if (saleRecordMapper.queryAllSaleRecord() == null) {
            return Response.failed("无销售信息");
        }

        return Response.success("success", saleRecordMapper.queryAllSaleRecord());
    }

    @Override
    public Response addSaleRecord(SaleRecord record) {
        if (record == null) {
            return Response.failed("销售信息不能为空");
        }

        if (saleRecordMapper.addSaleRecord(record)) {
            return Response.success("success", record);
        }

        return Response.failed("添加失败");
    }

    @Override
    public Response deleteSaleRecord(String saleNo) {
        if (saleNo == null || saleNo.equals("")) {
            return Response.failed("销售单号不能为空");
        }

        return saleRecordMapper.deleteSaleRecord(saleNo) ? Response.success("success") : Response.failed("failed");

    }

    @Override
    public Response updateSaleRecord(SaleRecord record) {
        if (record == null) {
            return Response.failed("销售信息不能为空");
        }

        if (saleRecordMapper.updateSaleRecord(record)) {
            return Response.success("success", record);
        }

        return Response.failed("更新失败");
    }
}
