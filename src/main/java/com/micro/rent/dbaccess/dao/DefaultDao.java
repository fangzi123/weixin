package com.micro.rent.dbaccess.dao;

import java.util.List;

import com.micro.rent.dbaccess.entity.SetFuncMenu;


public interface DefaultDao {
	/**
	 * @Description 查找所有有效菜单
	 * @return
	 * @author 
	 */
	List<SetFuncMenu> findAllMenu();
	
	/**
	 * @Description 通过用户名称查找有效菜单
	 * @param username
	 * @return
	 * @author 
	 */
	List<SetFuncMenu> findMenuByUserName(String username);
}
