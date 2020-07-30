package com.lwhtarena.cg.constants;

/****
 * redis key
 *****/
public interface CacheKey {
	/**
	 * 秒杀商品存储到前缀的KEY
	 */
	String SEC_KILL_GOODS_PREFIX="SeckillGoods_";


	/**
	 * 存储域订单的hash的大key
	 */
	String SEC_KILL_ORDER_KEY="SeckillOrder";

	/**
	 * 用户排队的队列的KEY
	 */
	String SEC_KILL_USER_QUEUE_KEY="SeckillOrderQueue";


	/**
	 * 用户排队标识的key (用于存储 谁 买了什么商品 以及抢单的状态)
	 */

	String SEC_KILL_USER_STATUS_KEY = "UserQueueStatus";


	/**
	 * 用于防止重复排队的hash的key 的值
	 */
	String SEC_KILL_QUEUE_REPEAT_KEY="UserQueueCount";


	/**
	 * 防止超卖的问题的 队列的key
	 */
	String SEC_KILL_CHAOMAI_LIST_KEY_PREFIX="SeckillGoodsCountList_";

	/**
	 * 所有的商品计数的大的key(用于存储所有的 商品 对应的 库存 数据)
	 *
	 * bigkey    field1(商品ID 1)    value(库存数2)
	 *           field1(商品ID 2)    value(库存数5)
	 */
	String SECK_KILL_GOODS_COUNT_KEY = "SeckillGoodsCount";



}
