package com.micro.rent.biz.shiro.service;

import java.util.List;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.SetResource;


/**
 * @Description 资源Service层接口
 * @author 
 * @date 2013-02-28
 * @version 1.0
 */
public interface SetResourceService {
	
	/**
	 * @Description 按条件分页查询资源
	 * @param page 分页对象
	 * @return
	 * @author 
	 */
	public void queryPaged(Page<SetResource> page);
	
	/**
	 * @Description 创建资源
	 * @param resource 
	 * @author 
	 */
	void create(SetResource resource);
	
	/**
	 * @Description 更新资源
	 * @param resource 
	 * @author 
	 */
	void update(SetResource resource);
	
	/**
	 * @Description 查询Sequences
	 * @author 
	 */
	String querySeq();
	

	/**
	 * @Description 查询所有资源记录
	 * @author 
	 */
	List<SetResource> queryAll();
	
	/**
	 * @Description 根据主键查询资源记录
	 * @param resourceId 
	 * @author 
	 */
	SetResource queryById(String resourceId);
	
	/**
	 * @Description 根据主键删除资源记录
	 * @param menuId 
	 * @author 
	 */
	void deleteMenu(String resourceId);
	

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
