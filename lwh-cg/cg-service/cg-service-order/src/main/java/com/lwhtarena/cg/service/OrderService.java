package com.lwhtarena.cg.service;

import com.github.pagehelper.PageInfo;
import com.lwhtarena.cg.order.pojo.Order;

import java.util.List;

/****
 * @Author:admin
 * @Description:Order业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OrderService {

    /***
     * Order多条件分页查询
     * @param order
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(Order order, int page, int size);

    /***
     * Order分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(int page, int size);

    /***
     * Order多条件搜索方法
     * @param order
     * @return
     */
    List<Order> findList(Order order);

    /***
     * 删除Order
     * @param id
     */
    void delete(String id);

    /***
     * 修改Order数据
     * @param order
     */
    void update(Order order);

    /***
     * 新增Order，添加订单
     * @param order
     */
    Order add(Order order);

    /**
     * 根据ID查询Order
     * @param id
     * @return
     */
     Order findById(String id);

    /***
     * 查询所有Order
     * @return
     */
    List<Order> findAll();

    /**
     * 更新对应的订单的状态
     * @param out_trade_no 订单
     * @param transaction_id 微信支付的交易流水号
     * 订单支付成功后，需要修改订单状态并持久化到数据库，修改订单的同时，需要
     * 将Redis中的订单删除，所以修改订单状态需要将订单日志也传过来
     */
    public void updateStatus(String out_trade_no,String transaction_id);

    /***
     * 如果用户订单支付失败了，或者支付超时了，我们需要删除用户订单，删除订单的同时需要回滚库存
     * 删除订单操作
     * @param id
     */
    void deleteOrder(String id);

    Integer closeOrder(String orderId);
}
