package com.alibaba.bean;


import lombok.Data;


/**
 * 进货记录
 */
@Data
public class StockRecord {
    /**
     * 审批人
     */
    private String audit;
    /**
     * 进货时间
     */
    private String createTime;
    /**
     * 进货金额
     */
    private long money;
    /**
     * 进货数量
     */
    private long num;
    /**
     * 进货单号
     */
    private String orderNo;
    /**
     * 供应商id
     */
    private String supplierId;
}