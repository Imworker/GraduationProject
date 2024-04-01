package com.alibaba.controller;


import com.alibaba.bean.SaleRecord;
import com.alibaba.bean.response.Response;
import com.alibaba.service.SaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicinalPSS/sale")
public class SaleRecordController {

    @Autowired
    private SaleRecordService saleRecordServiceImpl;

    @RequestMapping("/queryAll")
    public Response queryAll() {
        return saleRecordServiceImpl.queryAllSaleRecord();
    }

    @RequestMapping("/queryById")
    public Response queryById(String saleNo) {
        return saleRecordServiceImpl.querySaleRecordBySaleNo(saleNo);
    }

    @RequestMapping("/deleteRecord")

    public Response deleteRecord(String saleNo) {
        return saleRecordServiceImpl.deleteSaleRecord(saleNo);
    }

    @RequestMapping("/addOneRecord")
    public Response addOneRecord(SaleRecord saleRecord) {
        return saleRecordServiceImpl.addSaleRecord(saleRecord);
    }

    @RequestMapping("/modify")

    public Response modify(SaleRecord saleRecord) {
        return saleRecordServiceImpl.updateSaleRecord(saleRecord);
    }





}
