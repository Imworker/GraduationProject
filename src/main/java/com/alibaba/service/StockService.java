package com.alibaba.service;

import com.alibaba.bean.StockRecord;
import com.alibaba.bean.response.Response;

public interface StockService {
    /**
     * 根据编号查询库存记录
     * @param orderNo 记录编号
     * @return 库存数量
     */
    Response queryStockRecordByOrderNo(String orderNo);
    /**
     * 删除库存记录
     * @return 是否减少成功
     */
    Response reduceStockRecord(String orderNo );
    /**
     * 增加库存记录
     * @return 是否增加成功
     */
    Response addStock(StockRecord record);

    /**
     * 查询所有库存记录
     * @return 库存记录
     */
    Response queryAllStockRecord();

    /**
     * 修改库存记录信息
     * @return 库存记录
     */
    Response updateStockRecord(StockRecord record);
}
