package com.micro.rent.biz.weixin.service;

/**
 * @Description: 向微信用户发送模板消息
 * 
 * @author liqianxi
 * @date 2014-11-12
 */
public interface SendTemplateMessageService {

	/**
	 * 向微信用户发送模板消息
	 * 
	 * @param accessToken
	 * @param openId
	 * @param message
	 */
	void sendTemplateMessage(String accessToken, String openId, String message);
}
