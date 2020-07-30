package com.lwhtarena.cg.constants;

import lombok.Getter;

/**
 * 状态码
 */
@Getter
public enum ResultCodeEnum {

	SUCCESS(true, 20000,"成功"),
	UNKNOWN_REASON(false, 20001, "未知错误"),
	BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
	JSON_PARSE_ERROR(false, 21002, "json解析异常"),
	PARAM_ERROR(false, 21003, "参数不正确"),
	FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
	EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),

	VIDEO_UPLOAD_ERROR(false, 22001, "阿里云视频上传错误"),
	VIDEO_DELETE_ALIYUN_ERROR(false, 22002, "阿里云视频删除错误"),
	FETCH_VIDEO_UPLOADAUTH_ERROR(false, 22003, "阿里云获取上传凭证错误"),
	REFRESH_VIDEO_UPLOADAUTH_ERROR(false, 22004, "阿里云刷新上传凭证错误"),
	FETCH_VIDEO_PLAYAUTH_ERROR(false, 22005, "阿里云获取视频播放凭证错误"),

	URL_ENCODE_ERROR(false, 23001,"url编码失败"),
	ILLEGAL_CALLBACK_REQUEST_ERROR(false, 23002,"非法的回调请求"),
	FETCH_ACCESSTOKEN_FAILD(false, 23002,"获取微信登录授权码错误"),
	FETCH_USERINFO_ERROR(false, 23003,"获取微信用户信息错误");


	private Boolean success;

	private Integer code;

	private String message;

	ResultCodeEnum(){

	}

	ResultCodeEnum(Boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}
}