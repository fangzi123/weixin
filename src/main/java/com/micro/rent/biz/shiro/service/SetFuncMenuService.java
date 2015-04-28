package com.micro.rent.biz.shiro.service;

import java.util.List;
import java.util.Map;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.SetFuncMenu;

/**
 * @Description 菜单Service层接口
 * @author 
 * @date 2013-02-28
 * @version 1.0
 */
public interface SetFuncMenuService {
	
	/**
	 * @Description 按条件分页查询菜单
	 * @param page 分页对象
	 * @return
	 * @author 
	 */
	void queryPaged(Page<SetFuncMenu> page);
	/**
	 * @Description 创建菜单
	 * @param menu 
	 * @author 
	 */
	void create(SetFuncMenu menu);
	
	/**
	 * @Description 更新菜单
	 * @param menu 
	 * @author 
	 */
	void update(SetFuncMenu menu);
	
	/**
	 * @Description 查询Sequences
	 * @author 
	 */
	String querySeq();
	

	/**
	 * @Description 查询所有菜单记录
	 * @author 
	 */
	List<SetFuncMenu> queryAll();
	
	/**
	 * @Description 根据主键查询菜单记录
	 * @param menuId 
	 * @author 
	 */
	SetFuncMenu queryById(String menuId);
	
	/**
	 * @Description 根据主键删除菜单记录
	 * @param params 
	 * @author 
	 */
	void deleteMenu(Map<String, String> params);
	
	
	/**
	 * @Description 通过角色ID查询候选菜单
	 * @param roleId
	 * @return
	 * @author 
	 */
	public List<SetFuncMenu> queryCandidateResource(String roleId);
	/**
	 * @Description 通过角色ID查询已选菜单
	 * @param roleId
	 * @return
	 * @author 
	 */
	public List<SetFuncMenu> querySelectedResource(String roleId);

}
