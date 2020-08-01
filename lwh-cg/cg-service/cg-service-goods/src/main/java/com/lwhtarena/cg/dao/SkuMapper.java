package com.lwhtarena.cg.dao;
import com.lwhtarena.cg.goods.pojo.Sku;
import com.lwhtarena.cg.order.pojo.OrderItem;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:liwh
 * @Description:Sku的Dao
 * @Date 2020/07/09 0:18
 *****/
public interface SkuMapper extends Mapper<Sku> {

        /**
         * 扣减库存并增加销量
         * @param orderItem
         * @return
         */
        @Update("update tb_sku set num=num-#{num},sale_num=sale_num+#{num} where id=#{skuId} and num>=#{num}")
        int decrCount(OrderItem orderItem);
}
