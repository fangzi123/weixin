package com.micro.rent.common.support.task._enum;

/**
 * @Description 消息资源类型 
 * @author 
 * @date 2012-11-26
 * @version 1.0
 */
public enum MessageType {

	/**
	 * 异常资源类型：errors_message.properties
	 */
	ERRORS_TYPE ("errors"),
	
	/**
	 * 字典资源类型
	 */
	DICTS_TYPE ("dicts");
	
	MessageType(String code){
		this.code = code;
	}
	
	private final String code;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
}
