package com.micro.rent.biz.activity.service;

import java.util.List;

import com.micro.rent.dbaccess.entity.activity.Activity;
import com.micro.rent.dbaccess.entity.activity.ActivityOrder;
import com.micro.rent.dbaccess.entity.activity.UserActivity;

/**
 * 活动信息Service
 * @author liqianxi
 * @date 2014-12-09
 *
 */
public interface ActivityService {

	/**
	 * 取得活动信息
	 * @param activityId 活动ID
	 * @return 活动信息
	 */
	Activity getActivityInfo(int activityId);

	/**
	 * 取得活动预约信息
	 * @param activityId 活动ID
	 * @param weixinId 微信ID
	 * @return 活动预约信息
	 */
	ActivityOrder getActivityOrderInfo(int activityId, String weixinId);

	/**
	 * 增加活动预约信息
	 * @param activityId 活动预约信息
	 */
	void addActivityOrder(ActivityOrder activityOrder);

	/**
	 * 取得用户参与活动信息
	 * @param weixinId 微信ID
	 */
	List<UserActivity> getActivityInfoListByWeixinId(String weixinId);

	/**
	 * 更新预约活动所得奖励的使用状态
	 * @param activityId 活动ID
	 * @param weixinId 微信ID
	 * @param status 使用状态(0:未使用/1:已使用)
	 */
	void updateActivityOrderIsUse(int activityId, String weixinId, String status);
}
