package com.micro.rent.dbaccess.dao;

import java.util.List;

import com.micro.rent.dbaccess.entity.SetRoleGroup;


/**
 * @Description 角色组数据访问接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */

public interface SetRoleGroupDao {
	
	/**
	 * @Description 查询所有组
	 * @return
	 * @author 
	 */
	List<SetRoleGroup> queryAll();
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 * @author 
	 */
	String getSequences();
	
	/**
	 * @Description 插入新记录
	 * @param setRoleGroup
	 * @author 
	 */
	void insert(SetRoleGroup setRoleGroup);
	
	/**
	 * @Description 根据主键删除记录
	 * @param roleId
	 * @return
	 * @author 
	 */
	void deleteByPrimaryKey(String rgroupId);
	
	/**
	 * @Description 更新记录
	 * @param setRoleGroup
	 * @author 
	 */
	void updateByPrimaryKeySelective(SetRoleGroup setRoleGroup);
	
	
	/**
	 * @Description 通过ID查询候选记录
	 * @param userId
	 * @return
	 * @author 
	 */
	List<SetRoleGroup> queryCandidateResource(String userId);
	
	/**
	 * @Description 通过ID查询已选记录
	 * @param userId
	 * @return
	 * @author 
	 */
	List<SetRoleGroup> querySelectedResource(String userId);

}
