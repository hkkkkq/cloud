package com.lwhtarena.cg.service.impl;

import com.lwhtarena.cg.vo.Result;
import com.lwhtarena.cg.goods.feign.GoodsFeign;
import com.lwhtarena.cg.goods.pojo.Sku;
import com.lwhtarena.cg.goods.pojo.Spu;
import com.lwhtarena.cg.order.pojo.OrderItem;
import com.lwhtarena.cg.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.order.service.impl *
 * @since 1.0
 */
@Service
public class CartServiceImpl implements CartService {

    private static final String CART="Cart_";

    @Autowired
    private GoodsFeign goodsFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加入购物车
     * @param id  sku的ID
     * @param num 购买的数量
     * @param username  购买的商品的用户名
     */
    @Override
    public void add(Long id, Integer num, String username) {

        if(num<=0){
            //删除掉原来的商品
            redisTemplate.boundHashOps(CART + username).delete(id);
            return;
        }

        /**1.根据商品的SKU的ID 获取sku的数据**/
        Result<Sku> skuResult = goodsFeign.findById(id);
        Sku data = skuResult.getData();

        if (data != null) {
            /**2.根据sku的数据对象 获取 该SKU对应的SPU的数据**/
            Long spuId = Long.parseLong(data.getSpuId());

            Result<Spu> spuResult = goodsFeign.findSpuById(spuId);
            Spu spu = spuResult.getData();

            /**3.将数据存储到 购物车对象(order_item)中**/
            OrderItem orderItem = createOrderItem(id, num, data, spu);

            /**4.数据添加到redis中  key:用户名 field:sku的ID  value:购物车数据(order_item)**/
            redisTemplate.boundHashOps(CART + username).put(id, orderItem);// hset key field value   hget key field
        }

    }

    /**
     * 查询购物车列表数据
     * **/
    @Override
    public Map list(String username) {
        Map map = new HashMap();

        List<OrderItem> orderItemList = redisTemplate.boundHashOps(CART + username).values();
        map.put("orderItemList",orderItemList);

        //商品的总数量与总价格
        Integer totalNum = 0;
        Integer totalMoney = 0;

        for (OrderItem orderItem : orderItemList) {
            totalNum+=orderItem.getNum();
            totalMoney+=orderItem.getMoney();
        }

        map.put("totalNum",totalNum);
        map.put("totalMoney",totalMoney);

        return map;
    }

    /**
     * 3.将数据存储到 购物车对象(order_item)中
     * @param id
     * @param num
     * @param data
     * @param spu
     * @return
     */
    private OrderItem createOrderItem(Long id, Integer num, Sku data, Spu spu) {
        OrderItem orderItem = new OrderItem();
        orderItem.setCategoryId1(spu.getCategory1Id());
        orderItem.setCategoryId2(spu.getCategory2Id());
        orderItem.setCategoryId3(spu.getCategory3Id());
        orderItem.setSpuId(Long.parseLong(spu.getId()));
        orderItem.setSkuId(id);
        orderItem.setName(data.getName());//商品的名称  sku的名称
        orderItem.setPrice(data.getPrice());//sku的单价
        orderItem.setNum(num);//购买的数量
        orderItem.setMoney(orderItem.getNum() * orderItem.getPrice());//单价* 数量
        orderItem.setPayMoney(orderItem.getNum() * orderItem.getPrice());//单价* 数量
        orderItem.setImage(data.getImage());//商品的图片地址
        return orderItem;
    }
}
