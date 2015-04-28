package com.micro.rent.biz.shiro.service;

import java.util.List;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.RoleMenu;
import com.micro.rent.dbaccess.entity.SetFroleFmenu;
import com.micro.rent.dbaccess.entity.SetFuncRole;



/**
 * @Description 功能角色管理Service层接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */
public interface RoleMenuService {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param page 分页对象
	 * @return
	 * @author 
	 */
	void queryPaged(Page<RoleMenu> page);
	
	/**
	 * @Description 新增角色以及用户菜单关系
	 * @param role 角色对象
	 * @param list 角色菜单关系集合
	 * @return
	 * @author 
	 */
	public void create(SetFuncRole role, List<SetFroleFmenu> list);
	
	/**
	 * @Description 得到角色主键
	 * @return
	 * @author 
	 */
	public String queryRoleSeq();
	
	/**
	 * @Description 编辑角色以及用户菜单关系
	 * @param role 角色对象
	 * @param list 角色菜单关系集合
	 * @return
	 * @author 
	 */
	public void update(SetFuncRole role, List<SetFroleFmenu> list);
	
	/**
	 * @Description 删除角色以及用户菜单关系
	 * @param roleId 角色主键
	 * @return
	 * @author 
	 */
	public void delete(String roleId);

}
