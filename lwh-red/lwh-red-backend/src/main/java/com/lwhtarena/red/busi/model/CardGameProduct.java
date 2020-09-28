package com.lwhtarena.red.busi.model;

import java.util.Map;
import com.jfinal.plugin.activerecord.Model;
import com.lwhtarena.red.zcurd.common.DbMetaTool;

public class CardGameProduct extends Model<CardGameProduct> {
	private static final long serialVersionUID = 1L;
	public static final CardGameProduct me = new CardGameProduct();
		
	public Map<String, Object> getDictDatagameid() {
		return DbMetaTool.getDictData("select id,title from card_game");
	}	
		
	public Map<String, Object> getDictDataproductid() {
		return DbMetaTool.getDictData("select id,name from card_product");
	}	
	
}
