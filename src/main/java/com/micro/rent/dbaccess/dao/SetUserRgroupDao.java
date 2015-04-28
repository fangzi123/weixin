package com.micro.rent.dbaccess.dao;

import com.micro.rent.dbaccess.entity.SetUserRgroup;
import com.micro.rent.dbaccess.entity.SetUserRgroupKey;



/**
 * @Description 用户组关系数据访问接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */

public interface SetUserRgroupDao {
	
	/**
	 * @Description 插入新记录
	 * @param setUserRgroup
	 * @author 
	 */
	void insert(SetUserRgroup setUserRgroup);
	
	
	/**
	 * @Description 删除当前用户对应的所有组记录
	 * @param userId
	 * @return
	 * @author 
	 */
	void deleteByUserId(String userId);
	
	/**
	 * @Description 更新记录
	 * @param setRgroupRoleKey
	 * @author 
	 */
	void updateByPrimaryKeySelective(SetUserRgroupKey setUserRgroupKey);
	
	

}
