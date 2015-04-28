package com.micro.rent.dbaccess.entity.activity;

/**
 * 活动预约信息
 * @author liqianxi
 * @date 2014-12-09
 *
 */
public class ActivityOrder {

	/**
	 * 活动预约ID
	 */
	private int activityOrderId;

	/**
	 * 活动ID
	 */
	private int activityId;

	/**
	 * 微信ID
	 */
	private String weixinId;

	/**
	 * 预约电话
	 */
	private String telephone;

	/**
	 * 是否已使用
	 */
	private String isUse;

	/**
	 * 微信用户别名
	 */
	private String nickName;

	/**
	 * 微信用户性别
	 */
	private String gender;

	/**
	 * 创建时间
	 */
	private long createTime;

	/**
	 * 更新时间
	 */
	private long updateTime;

	/**
	 * 微信用户头像
	 */
	private String headImgUrl;

	/**
	 * 微信用户获得奖励值
	 */
	private int reward;

	/**
	 * 取得活动预约ID
	 * @return 活动预约ID
	 */
	public int getActivityOrderId() {
		return activityOrderId;
	}

	/**
	 * 设定活动预约ID
	 * @param activityOrderId 活动预约ID
	 */
	public void setActivityOrderId(int activityOrderId) {
		this.activityOrderId = activityOrderId;
	}

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
	 * 取得微信ID
	 * @return 微信ID
	 */
	public String getWeixinId() {
		return weixinId;
	}

	/**
	 * 设定微信ID
	 * @param weixinId 微信ID
	 */
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}

	/**
	 * 取得预约电话
	 * @return 预约电话
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设定预约电话
	 * @param telephone 预约电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * 取得微信用户别名
	 * @return 微信用户别名
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设定微信用户别名
	 * @param nickName 微信用户别名
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 取得微信用户性别
	 * @return 微信用户性别(1:男/2:女)
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 设定微信用户性别
	 * @param gender 微信用户性别(1:男/2:女/0:未知)
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * 取得微信用户头像
	 * @return 微信用户头像
	 */
	public String getHeadImgUrl() {
		return headImgUrl;
	}

	/**
	 * 设定微信用户头像
	 * @param headImgUrl 微信用户头像
	 */
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	/**
	 * 取得微信用户获得奖励值
	 * @return 微信用户获得奖励值
	 */
	public int getReward() {
		return reward;
	}

	/**
	 * 设定微信用户获得奖励值
	 * @param reward 微信用户获得奖励值
	 */
	public void setReward(int reward) {
		this.reward = reward;
	}

}
