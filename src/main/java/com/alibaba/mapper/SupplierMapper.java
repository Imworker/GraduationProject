package com.alibaba.mapper;

import com.alibaba.bean.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierMapper {

    @Select(value = "select * from supplier where supplier_id=#{supplierId} and deleted=0")
    Supplier querySupplierById(String supplierId);

    @Select(value = "select * from supplier where deleted=0")
    List<Supplier> queryAllSupplier();

    @Select(value = "insert into supplier (supplier_id,supplier_name,phone,price) values(#{supplierId},#{supplierName},#{phone},#{price})")
    boolean addSupplier(Supplier supplier);

    @Select(value = "update supplier set deleted=1 where supplier_id=#{supplierId}")
    boolean deleteSupplier(String supplierId);

}
