package com.micro.rent.biz.activity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.rent.biz.activity.service.ActivityService;
import com.micro.rent.dbaccess.dao.activity.ActivityDao;
import com.micro.rent.dbaccess.dao.activity.ActivityOrderDao;
import com.micro.rent.dbaccess.entity.activity.Activity;
import com.micro.rent.dbaccess.entity.activity.ActivityOrder;
import com.micro.rent.dbaccess.entity.activity.UserActivity;

/**
 * 活动信息Service实现
 * @author liqianxi
 * @date 2014-12-09
 *
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	private transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private ActivityOrderDao activityOrderDao;

	@Override
	public Activity getActivityInfo(int activityId) {
		return activityDao.getActivityInfo(activityId);
	}

	@Override
	public ActivityOrder getActivityOrderInfo(int activityId, String weixinId) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("activityId", activityId);
		condition.put("weixinId", weixinId);
		return activityOrderDao.getActivityOrderInfo(condition);
	}

	@Override
	public void addActivityOrder(ActivityOrder activityOrder) {
		long createTime = System.currentTimeMillis() / 1000;
		// 设定使用状态为“未使用”
		activityOrder.setIsUse(ActivityOrderDao.IS_USE_NO);
		// 设定创建、更新时间
		activityOrder.setCreateTime(createTime);
		activityOrder.setUpdateTime(createTime);
		log.info("增加活动预约信息[id:" + activityOrder.getActivityId()
				+ ",weixinId:" + activityOrder.getWeixinId()
				+ ",telephone:" + activityOrder.getTelephone()
				+ ",nickName:" + activityOrder.getNickName()
				+ ",gender:" + activityOrder.getGender()
				+ ",createTime:" + createTime + "]");
		activityOrderDao.insertActivityOrder(activityOrder);
	}

	@Override
	public List<UserActivity> getActivityInfoListByWeixinId(String weixinId) {
		List<UserActivity> result = activityDao.getActivityInfoListByWeixinId(weixinId);
		return result;
	}

	/**
	 * 更新预约活动所得奖励的使用状态
	 * @param activityId 活动ID
	 * @param weixinId 微信ID
	 * @param status 使用状态(0:未使用/1:已使用)
	 */
	@Override
	public void updateActivityOrderIsUse(int activityId, String weixinId, String status) {
		ActivityOrder activityOrder = new ActivityOrder();
		activityOrder.setActivityId(activityId);
		activityOrder.setWeixinId(weixinId);
		activityOrder.setIsUse(status);
		activityOrder.setUpdateTime(System.currentTimeMillis() / 1000);
		activityOrderDao.updateActivityOrderIsUse(activityOrder);
	}

}
