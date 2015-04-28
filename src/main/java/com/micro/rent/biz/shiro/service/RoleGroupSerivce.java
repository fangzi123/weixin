package com.micro.rent.biz.shiro.service;

import java.util.List;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.RoleGroup;
import com.micro.rent.dbaccess.entity.SetFuncRole;
import com.micro.rent.dbaccess.entity.SetResourceRole;
import com.micro.rent.dbaccess.entity.SetRgroupFrole;
import com.micro.rent.dbaccess.entity.SetRgroupRrole;
import com.micro.rent.dbaccess.entity.SetRoleGroup;



/**
 * @Description 角色组管理Service层接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */
public interface RoleGroupSerivce {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param page 分页对象
	 * @return
	 * @author 
	 */
	public void queryPaged(Page<RoleGroup> page);
	
	/**
	 * @Description 新增角色组以及角色组关系
	 * @param roleGroup 组对象
	 * @param frList 功能角色组关系集合
	 * @param rrList 资源角色组关系集合
	 * @return
	 * @author 
	 */
	public void create(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList);
	
	/**
	 * @Description 编辑角色组以及角色组关系
	 * @param roleGroup 组对象
	 * @param frList 功能角色组关系集合
	 * @param rrList 资源角色组关系集合
	 * @param rgroupId 角色组主键
	 * @return
	 * @author 
	 */
	public void update(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList, String rgroupId);
	
	/**
	 * @Description 删除角色组以及角色组关系
	 * @param rgroupId 角色组主键
	 * @return
	 * @author 
	 */
	public void delete(String rgroupId);
	
	/**
	 * @Description 得到角色主键
	 * @return
	 * @author 
	 */
	public String queryGroupSeq();

	/**
	 * @Description 查询所有功能角色
	 * @return
	 * @author 
	 */
	List<SetFuncRole> queryFrAll();
	
	/**
	 * @Description 查询所有资源角色
	 * @return
	 * @author 
	 */
	List<SetResourceRole> queryRrAll();
	
	/**
	 * @Description 通过角色组ID查询候选功能角色
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetFuncRole> queryFCandidateResource(String rgroupId);
	/**
	 * @Description 通过角色组ID查询已选功能角色
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetFuncRole> queryFSelectedResource(String rgroupId);
	
	/**
	 * @Description 通过角色组ID查询候选资源角色
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetResourceRole> queryRCandidateResource(String rgroupId);
	/**
	 * @Description 通过角色组ID查询已选资源角色
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetResourceRole> queryRSelectedResource(String rgroupId);

}
