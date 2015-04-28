package com.micro.rent.dbaccess.dao.activity;

import java.util.Map;

import com.micro.rent.dbaccess.entity.activity.ActivityOrder;

/**
 * 活动预约查询接口
 * @author liqianxi
 * @date 2014-12-09
 *
 */
public interface ActivityOrderDao {
	
	/**
	 * 奖励是否已使用(0:未使用)
	 */
	public static final String IS_USE_NO = "0";
	
	/**
	 * 奖励是否已使用(1:已使用)
	 */
	public static final String IS_USE_YES = "1";
	
	/**
	 * 性别(1:男)
	 */
	public static final String GENDER_MALE = "1";
	
	/**
	 * 性别(2:女)
	 */
	public static final String GENDER_FEMALE = "2";

	/**
	 * 取得活动信息
	 * @param condition 查询条件(活动ID、微信ID)
	 * @return 活动预约信息
	 */
	ActivityOrder getActivityOrderInfo(Map<String, Object> condition);
	
	/**
	 * 增加活动预约信息
	 * @param activityOrder 活动预约信息
	 */
	void insertActivityOrder(ActivityOrder activityOrder);

	/**
	 * 更新预约活动所得奖励的使用状态
	 * @param activityOrder 条件
	 */
	void updateActivityOrderIsUse(ActivityOrder activityOrder);
	
}
