package com.alibaba.service;


import com.alibaba.bean.SaleRecord;
import com.alibaba.bean.response.Response;

public interface SaleRecordService {

    Response querySaleRecordBySaleNo(String saleNo);

    Response queryAllSaleRecord();

    Response addSaleRecord(SaleRecord record);

    Response deleteSaleRecord(String saleNo);

    Response updateSaleRecord(SaleRecord record);



}
