package com.lwhtarena.glmall.ware.vo;

import lombok.Data;

/**
 * @author liwh
 * @Title: MemberAddressVo
 * @Package com.lwhtarena.glmall.ware.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:18
 */
@Data
public class MemberAddressVo {

    private Long id;
    /**
     * member_id
     */
    private Long memberId;
    /**
     * 收货人姓名
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 省份/直辖市
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 详细地址(街道)
     */
    private String detailAddress;
    /**
     * 省市区代码
     */
    private String areacode;
    /**
     * 是否默认
     */
    private Integer defaultStatus;

}
