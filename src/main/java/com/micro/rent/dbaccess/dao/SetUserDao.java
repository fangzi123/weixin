package com.micro.rent.dbaccess.dao;

import java.util.Map;

import com.micro.rent.dbaccess.entity.SetUser;

/**
 * @Description 用户数据访问接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */

public interface SetUserDao {
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 * @author 
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param user
	 * @author 
	 */
	void insert(SetUser user);
	
	/**
	 * @Description 根据主键删除记录
	 * @param userId
	 * @return
	 * @author 
	 */
	void deleteByPrimaryKey(String userId);
	
	/**
	 * @Description 更新记录
	 * @param user
	 * @author 
	 */
	void updateByPrimaryKeySelective(SetUser user);
	
	/**
	 * @Description 根据主键查询记录
	 * @param userId
	 * @author 
	 */
	SetUser selectByPrimaryKey(String userId);
	
	/**
	 * 查询用户名是否存在
	 * @param userName
	 * @return
	 */
	Integer queryUserExist(String userName);

	/**
	 * 根据用户名返回用户信息
	 * @param userName
	 * @return
	 */
	SetUser queryUserByUserName(String userName);
	
	/**
	 * 修改密码
	 * @param map
	 */
	void updateUserPasswd(Map<String,Object> mpParams);
}
