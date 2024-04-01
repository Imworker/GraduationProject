package com.alibaba.service.Impl;

import com.alibaba.bean.StockRecord;
import com.alibaba.bean.response.Response;
import com.alibaba.mapper.StockRecordMapper;

import com.alibaba.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRecordMapper stockRecordMapper;

    @Override
    public Response queryStockRecordByOrderNo(String orderNo) {
        StockRecord stockRecord  = stockRecordMapper.queryStockRecordByOrderNo(orderNo);
        if(stockRecord == null )
            return Response.failed("failed");
        return Response.success("success", stockRecord);
    }

    @Override
    public Response reduceStockRecord(String orderNo) {
        if (stockRecordMapper.reduceStockRecord(orderNo))
            return Response.success("success");
        else
            return Response.failed("failed" );
    }

    @Override
    public Response addStock(StockRecord record) {
        if (record == null)
            return Response.failed("failed");

        if (stockRecordMapper.addStock(record)) {
            return Response.success("success", record);
        }
        return Response.failed("failed");
    }

    @Override
    public Response queryAllStockRecord() {
        List<StockRecord> stockRecords = stockRecordMapper.queryAllStockRecord();
        if(stockRecords.size() == 0)
            return Response.failed("failed");
        return Response.success("success", stockRecords);
    }

    @Override
    public Response updateStockRecord(StockRecord record) {
        if (record == null)
            return Response.failed("failed");
        if (stockRecordMapper.updateStockRecord(record))
            return Response.success("success", record);
        return Response.failed("failed");
    }
}
