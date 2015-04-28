package com.micro.rent.dbaccess.dao.activity;

import java.util.List;

import com.micro.rent.dbaccess.entity.activity.Activity;
import com.micro.rent.dbaccess.entity.activity.UserActivity;

/**
 * 活动信息查询接口
 * @author liqianxi
 * @date 2014-12-09
 *
 */
public interface ActivityDao {
	
	/**
	 * 奖励类型(1:租房券)
	 */
	public static final String REWARD_TYPE_ZUFANGQUAN = "1";
	
	/**
	 * 活动进行状态(0:未开始)
	 */
	public static final int ACTIVITY_STATE_NOT_BEGIN = 0;
	
	/**
	 * 活动进行状态(1:进行中)
	 */
	public static final int ACTIVITY_STATE_ON_GOING = 1;
	
	/**
	 * 活动进行状态(-1:已结束)
	 */
	public static final int ACTIVITY_STATE_END = -1;

	/**
	 * 取得活动信息
	 * @param activityId 活动ID
	 * @return 活动信息
	 */
	Activity getActivityInfo(int activityId);

	/**
	 * 取得用户参与活动信息
	 * @param weinxinId 微信ID
	 * @return 用户参与活动信息
	 */
	List<UserActivity> getActivityInfoListByWeixinId(String weinxinId);
}
