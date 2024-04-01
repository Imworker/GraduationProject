package com.alibaba.mapper;

import com.alibaba.bean.StockRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface StockRecordMapper {

    @Select(value = "select * from stock_record where order_no=#{orderNo} and deleted=0")
    StockRecord queryStockRecordByOrderNo(String orderNo);

    @Select(value = "update from stock_record set deleted=1 where order_no=#{orderNo}")
    boolean reduceStockRecord(String orderNo);

    @Select(value = "insert into stock_record (order_no,supplier_id,create_time,num,money,audit) values(#{orderNo},#{supplierId},#{createTime},#{num},#{money},#{audit})")
    boolean addStock(StockRecord record);

    @Select(value = "select * from stock_record where deleted=0 ")
    List<StockRecord> queryAllStockRecord();

    @Select(value = "update stock_record set order_no=#{orderNo} , " +
            "supplier = #{supplierId} , create_time = #{createTime} ," +
            "num = #{num} , money = #{money} , audit = #{audit} where order_no=#{orderNo} and deleted=0")
    boolean updateStockRecord(StockRecord record);
}
