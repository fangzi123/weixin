package com.micro.rent.dbaccess.dao;

import java.util.List;
import java.util.Map;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.SetResource;


/**
 * @Description 资源数据访问接口
 * @author 
 * @date 2013-02-28
 * @version 1.0
 */

public interface SetResourceDao {
	
	/**
	 * @Description 插入新记录
	 * @param resource
	 * @author 
	 */
	void insert(SetResource resource);
	
	/**
	 * @Description 更新记录
	 * @param resource
	 * @author 
	 */
	void updateByPrimaryKeySelective(SetResource resource);
	
	/**
	 * @Description 查询Sequences
	 * @param 
	 * @author 
	 */
	String getSequences();
	
	

	/**
	 * @Description 查询分页记录
	 * @param params
	 * @return 
	 * @author 
	 */
	//List<SetResource> queryPaged(Map<String, Object> params);
	
	List<SetResource> queryPaged(Page<SetResource> page);
	
	
	/**
	 * @Description 查询记录总数
	 * @param params
	 * @return
	 * @author 
	 */
	int queryTotalCount(Map<String, Object> params);
	
	/**
	 * @Description 查询所有记录
	 * @return
	 * @author 
	 */
	List<SetResource> queryAll();
	
	/**
	 * @Description 根据主键查询记录
	 * @param resourceId
	 * @return
	 * @author 
	 */
	SetResource selectByPrimaryKey(String resourceId);
	
	/**
	 * @Description 根据主键删除记录
	 * @param resourceId
	 * @return
	 * @author 
	 */
	void deleteByPrimaryKey(String resourceId);
	
	/**
	 * @Description 通过资源角色ID查询候选资源
	 * @param resourceRoleId
	 * @return
	 * @author caobin
	 */
	List<SetResource> queryCandidateResource(String resourceRoleId);
	
	/**
	 * @Description 通过资源角色ID查询已选资源
	 * @param resourceRoleId
	 * @return
	 * @author caobin
	 */
	List<SetResource> querySelectedResource(String resourceRoleId);

}
