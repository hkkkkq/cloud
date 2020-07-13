package com.lwhtarena.cg.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lwhtarena.cg.annotation.CanalEventListener;
import com.lwhtarena.cg.annotation.ListenPoint;
import com.lwhtarena.cg.annotation.ddl.AlertTableListenPoint;
import com.lwhtarena.cg.annotation.ddl.CreateIndexListenPoint;
import com.lwhtarena.cg.annotation.ddl.CreateTableListenPoint;
import com.lwhtarena.cg.annotation.ddl.DropTableListenPoint;
import com.lwhtarena.cg.annotation.dml.DeleteListenPoint;
import com.lwhtarena.cg.annotation.dml.InsertListenPoint;
import com.lwhtarena.cg.annotation.dml.UpdateListenPoint;
import com.lwhtarena.cg.content.feign.ContentFeign;
import com.lwhtarena.cg.content.pojo.Content;
import com.lwhtarena.cg.core.CanalMsg;
import com.lwhtarena.cg.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import java.util.List;

/**
 * 功能描述: 注解方法测试
 * @author: 刘猛
 *  rowData.getAfterColumnsList() 增加、修改
 *  rowData.getBeforeColumnsList() 删除、修改
 * @date: 2019/6/17 13:48
 **/
@CanalEventListener
public class MyAnnoEventListener {

	@Autowired
	private ContentFeign contentFeign;
	//字符串
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 增加数据监听
	 * @param canalMsg 当前操作对象的类型
	 * @param rowChange 发生变更的一行数据
	 */
	@InsertListenPoint
	public void onEventInsertData(CanalMsg canalMsg, CanalEntry.RowChange rowChange) {
		System.out.println("======================注解方式（新增数据操作）==========================");
		List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
		for (CanalEntry.RowData rowData : rowDatasList) {
			/**当前操作的类型**/
			String sql = "use " + canalMsg.getSchemaName() + ";\n";
			StringBuffer colums = new StringBuffer();
			StringBuffer values = new StringBuffer();
			/**增加、修改**/
			rowData.getAfterColumnsList().forEach((c) -> {
				colums.append(c.getName() + ",");
				values.append("'" + c.getValue() + "',");
			});
			
			
			sql += "INSERT INTO " + canalMsg.getTableName() + "(" + colums.substring(0, colums.length() - 1) + ") VALUES(" + values.substring(0, values.length() - 1) + ");";
			System.out.println(sql);
		}
		System.out.println("\n======================================================");
		
	}

	/**
	 * 更新修改监听
	 * @param canalMsg
	 * @param rowChange
	 */
	@UpdateListenPoint
	public void onEventUpdateData(CanalMsg canalMsg, CanalEntry.RowChange rowChange) {
		System.out.println("======================注解方式（更新数据操作）==========================");
		List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
		for (CanalEntry.RowData rowData : rowDatasList) {

			String sql = "use " + canalMsg.getSchemaName() + ";\n";
			StringBuffer updates = new StringBuffer();
			StringBuffer conditions = new StringBuffer();
			rowData.getAfterColumnsList().forEach((c) -> {
				if (c.getIsKey()) {
					conditions.append(c.getName() + "='" + c.getValue() + "'");
				} else {
					updates.append(c.getName() + "='" + c.getValue() + "',");
				}
			});
			sql += "UPDATE " + canalMsg.getTableName() + " SET " + updates.substring(0, updates.length() - 1) + " WHERE " + conditions;
			System.out.println(sql);
		}
		System.out.println("\n======================================================");
	}

	/**
	 * 删除监听
	 * @param rowChange
	 * @param canalMsg
	 */
	@DeleteListenPoint
	public void onEventDeleteData(CanalEntry.RowChange rowChange, CanalMsg canalMsg) {
		
		System.out.println("======================注解方式（删除数据操作）==========================");
		List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
		for (CanalEntry.RowData rowData : rowDatasList) {
			
			if (!CollectionUtils.isEmpty(rowData.getBeforeColumnsList())) {
				String sql = "use " + canalMsg.getSchemaName() + ";\n";
				
				sql += "DELETE FROM " + canalMsg.getTableName() + " WHERE ";
				StringBuffer idKey = new StringBuffer();
				StringBuffer idValue = new StringBuffer();
				for (CanalEntry.Column c : rowData.getBeforeColumnsList()) {
					if (c.getIsKey()) {
						idKey.append(c.getName());
						idValue.append(c.getValue());
						break;
					}
					
					
				}
				
				sql += idKey + " =" + idValue + ";";
				System.out.println(sql);
			}
			System.out.println("\n======================================================");
			
		}
	}

	/**
	 * 监听创建表
	 * @param rowChange
	 */
	@CreateTableListenPoint
	public void onEventCreateTable(CanalEntry.RowChange rowChange) {
		System.out.println("======================注解方式（创建表操作）==========================");
		System.out.println("use " + rowChange.getDdlSchemaName() + ";\n" + rowChange.getSql());
		System.out.println("\n======================================================");
	}
	
	@DropTableListenPoint
	public void onEventDropTable(CanalEntry.RowChange rowChange) {
		System.out.println("======================注解方式（删除表操作）==========================");
		System.out.println("use " + rowChange.getDdlSchemaName() + ";\n" + rowChange.getSql());
		System.out.println("\n======================================================");
	}
	
	@AlertTableListenPoint
	public void onEventAlertTable(CanalEntry.RowChange rowChange) {
		System.out.println("======================注解方式（修改表信息操作）==========================");
		System.out.println("use " + rowChange.getDdlSchemaName() + ";\n" + rowChange.getSql());
		System.out.println("\n======================================================");
	}
	
	@CreateIndexListenPoint
	public void onEventCreateIndex(CanalMsg canalMsg,CanalEntry.RowChange rowChange){
		System.out.println("======================注解方式（创建索引操作）==========================");
		System.out.println("use " + canalMsg.getSchemaName()+ ";\n" + rowChange.getSql());
		System.out.println("\n======================================================");
	}

	/**
	 * 自定义数据库的 操作来监听
	 * @param eventType
	 * @param rowData
	 * destination = "广告词条"
	 */
	@ListenPoint(destination = "example",
			schema = "changgou_content",
			table = {"tb_content", "tb_content_category"},
			eventType = {
					CanalEntry.EventType.UPDATE,
					CanalEntry.EventType.DELETE,
					CanalEntry.EventType.INSERT})
	public void onEventCustomUpdate(CanalEntry.EventType eventType, CanalEntry.RowChange rowData) {
		System.out.println("======================注解方式（监听tb_content和tb_content_category）==========================");

		//1.获取列名 为category_id的值
		String categoryId = getColumnValue(eventType, rowData);
		//2.调用feign 获取该分类下的所有的广告集合
		Result<List<Content>> categoryresut = contentFeign.findByCategory(Long.valueOf(categoryId));
		List<Content> data = categoryresut.getData();
		//3.使用redisTemplate存储到redis中
		stringRedisTemplate.boundValueOps("content_" + categoryId).set(JSON.toJSONString(data));
	}

	/**
	 * 业务操作
	 * @param eventType
	 * @param rowData
	 * @return
	 */
	private String getColumnValue(CanalEntry.EventType eventType, CanalEntry.RowChange rowData) {
		String categoryId = "";
		//判断 如果是删除  则获取beforlist
		List<CanalEntry.RowData> rowDatasList = rowData.getRowDatasList();
		if (eventType == CanalEntry.EventType.DELETE) {
			for(CanalEntry.RowData rd : rowDatasList){
				if (!CollectionUtils.isEmpty(rd.getBeforeColumnsList())) {
					for (CanalEntry.Column c : rd.getBeforeColumnsList()) {
						if (c.getName().equalsIgnoreCase("category_id")) {
							categoryId = c.getValue();
							break;
						}
					}
				}
			}
		} else {
			//判断 如果是添加 或者是更新 获取afterlist
			for(CanalEntry.RowData rd : rowDatasList){
				if (!CollectionUtils.isEmpty(rd.getBeforeColumnsList())) {
					for (CanalEntry.Column column : rd.getAfterColumnsList()) {
						if (column.getName().equalsIgnoreCase("category_id")) {
							categoryId = column.getValue();
							return categoryId;
						}
					}
				}
			}
		}
		return categoryId;
	}
	
	
}
