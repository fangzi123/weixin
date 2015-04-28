package com.micro.rent.dbaccess.entity.activity;

public class UserActivity {

	/**
	 * 活动ID
	 */
	private int activityId;

	/**
	 * 活动名称
	 */
	private String activityName;

	/**
	 * 活动开始时间
	 */
	private long startTime;

	/**
	 * 活动结束时间
	 */
	private long endTime;

	/**
	 * 活动描述
	 */
	private String activityDesc;

	/**
	 * 活动页面链接
	 */
	private String activityUrl;

	/**
	 * 奖励类型
	 */
	private String rewardType;

	/**
	 * 活动奖励值
	 */
	private int reward;

	/**
	 * 用户获得奖励值
	 */
	private int userReward;

	/**
	 * 是否已使用
	 */
	private String isUse;

	/**
	 * 创建时间
	 */
	private long createTime;

	/**
	 * 更新时间
	 */
	private long updateTime;

	/**
	 * 活动当前状态
	 */
	private int activityStatus;

	/**
	 * 用户微信ID
	 */
	private String weixinId;

	/**
	 * 取得活动ID
	 * @return 活动ID
	 */
	public int getActivityId() {
		return activityId;
	}

	/**
	 * 设定活动ID
	 * @param activityId 活动ID
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	/**
	 * 取得活动名称
	 * @return 活动名称
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * 设定活动名称
	 * @param activityName 活动名称
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * 取得活动开始时间
	 * @return 活动开始时间
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * 设定活动开始时间
	 * @param startTime 活动开始时间
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * 取得活动结束时间
	 * @return 活动结束时间
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * 设定活动结束时间
	 * @param endTime 活动结束时间
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * 取得活动描述
	 * @return 活动描述
	 */
	public String getActivityDesc() {
		return activityDesc;
	}

	/**
	 * 设定活动描述
	 * @param activityDesc 活动描述
	 */
	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	/**
	 * 取得活动页面链接
	 * @return 活动页面链接
	 */
	public String getActivityUrl() {
		return activityUrl;
	}

	/**
	 * 设定活动页面链接
	 * @param activityUrl 活动页面链接
	 */
	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	/**
	 * 取得奖励类型
	 * @return 奖励类型
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * 设定奖励类型
	 * @param rewardType 奖励类型
	 */
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	/**
	 * 取得活动奖励值
	 * @return 活动奖励值
	 */
	public int getReward() {
		return reward;
	}

	/**
	 * 设定活动奖励值
	 * @param reward 活动奖励值
	 */
	public void setReward(int reward) {
		this.reward = reward;
	}

	/**
	 * 取得用户获得奖励值
	 * @return 用户获得奖励值
	 */
	public int getUserReward() {
		return userReward;
	}

	/**
	 * 设定用户获得奖励值
	 * @param userReward 用户获得奖励值
	 */
	public void setUserReward(int userReward) {
		this.userReward = userReward;
	}

	/**
	 * 取得是否已使用
	 * @return 是否已使用
	 */
	public String getIsUse() {
		return isUse;
	}

	/**
	 * 设定是否已使用
	 * @param isUse 是否已使用(0:未使用/1:已使用)
	 */
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	/**
	 * 取得创建时间
	 * @return 创建时间
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * 设定创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得更新时间
	 * @return 更新时间
	 */
	public long getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设定更新时间
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 取得活动当前状态
	 * @return 活动当前状态
	 */
	public int getActivityStatus() {
		return activityStatus;
	}

	/**
	 * 设定活动当前状态
	 * @param activityStatus 活动当前状态
	 */
	public void setActivityStatus(int activityStatus) {
		this.activityStatus = activityStatus;
	}

	/**
	 * 取得用户微信ID
	 * @return 用户微信ID
	 */
	public String getWeixinId() {
		return weixinId;
	}

	/**
	 * 设定用户微信ID
	 * @param weixinId 用户微信ID
	 */
	public void setActivityStatus(String weixinId) {
		this.weixinId = weixinId;
	}

}
