package com.alibaba.mapper;

import com.alibaba.bean.SaleRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface SaleRecordMapper {

    @Select(value = "select * from sale_record where sale_no=#{saleNo} and deleted=0")
    SaleRecord querySaleRecordBySaleNo(String saleNo);

    @Select(value = "select * from sale_record where deleted=0")
    List<SaleRecord> queryAllSaleRecord();

    @Select(value = "insert into sale_record (sale_no,customer_id,create_time,num,money,audit) values(#{saleNo},#{customerId},#{createTime},#{num},#{money},#{audit})")
    boolean addSaleRecord(SaleRecord record);

    @Select(value = "update sale_record set deleted=1 where sale_no=#{saleNo}")
    boolean deleteSaleRecord(String saleNo);

    @Select(value = "update sale_record set sale_no=#{saleNo} , " +
            "customer_id = #{customerId} , create_time = #{createTime} ," +
            "num = #{num} , money = #{money} , audit = #{audit} where sale_no=#{saleNo} and deleted=0")

    boolean updateSaleRecord(SaleRecord record);



}
