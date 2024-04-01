package com.alibaba.controller;

import com.alibaba.bean.StockRecord;
import com.alibaba.bean.response.Response;
import com.alibaba.service.StockService;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicinalPSS/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping("/queryAll")
    public Response queryAll() {
        return stockService.queryAllStockRecord();
    }


    @RequestMapping("/queryById")
    public Response queryById(String orderNo) {
        return stockService.queryStockRecordByOrderNo(orderNo);
    }

    @RequestMapping("/deleteRecord")
    public Response deleteRecord(String orderNo) {
        return stockService.reduceStockRecord(orderNo);
    }

    @RequestMapping("/addOneRecord")
    public Response addOneRecord(@RequestBody StockRecord stockRecord) {
        return stockService.addStock(stockRecord);
    }

    @RequestMapping("/modify")
    public Response modify(@RequestBody StockRecord stockRecord) {
        return stockService.updateStockRecord(stockRecord);
    }



}
