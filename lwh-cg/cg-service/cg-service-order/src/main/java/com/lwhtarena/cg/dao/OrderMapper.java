package com.lwhtarena.cg.dao;


import com.lwhtarena.cg.order.pojo.Order;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:admin
 * @Description:Order的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface OrderMapper extends Mapper<Order> {

    //订单表的状态设计不完善
    @Update("UPDATE `tb_order` SET `is_delete` = '1' WHERE `id` = #{orderId} AND `is_delete` = '0'")
    Integer closeOrder(String orderId);
}
