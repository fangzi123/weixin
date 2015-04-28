package com.micro.rent.biz.shiro.service;

import java.math.BigDecimal;
import java.util.List;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.SetRoleGroup;
import com.micro.rent.dbaccess.entity.SetUser;
import com.micro.rent.dbaccess.entity.SetUserRgroup;
import com.micro.rent.dbaccess.entity.UserGroup;



/**
 * @Description 用户组管理Service层接口
 * @author 
 * @date 2013-03-01
 * @version 1.0
 */
public interface UserGroupService {
	
	/**
	 * @Description 按条件分页查询结算菜单
	 * @param page 分页对象
	 * @return
	 * @author 
	 */
	public void queryPaged(Page<UserGroup> page);
	
	/**
	 * @Description 新增用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 * @author 
	 */
	public void create(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 编辑用户以及用户组关系
	 * @param roleGroup 组对象
	 * @param list 角色组关系集合
	 * @return
	 * @author 
	 */
	public void update(SetUser user, List<SetUserRgroup> list);
	
	/**
	 * @Description 删除用户以及用户组关系
	 * @param userId 用户主键
	 * @return
	 * @author 
	 */
	public void delete(String userId);
	
	/**
	 * @Description 得到用户主键
	 * @return
	 * @author 
	 */
	public String queryUserSeq();

	/**
	 * @Description 查询所有组
	 * @return
	 * @author 
	 */
	List<SetRoleGroup> queryAll();
	
	/**
	 * @Description 通过角色ID查询候选角色组
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetRoleGroup> queryCandidateResource(String userId);
	/**
	 * @Description 通过角色ID查询已选角色组
	 * @param rgroupId
	 * @return
	 * @author 
	 */
	public List<SetRoleGroup> querySelectedResource(String userId);
	
	/**
	 * @Description 根据主键查询用户
	 * @param userId
	 * @return
	 * @author 
	 */
	public SetUser queryById(String userId);
	
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
    public SetUser queryUserByUserName(String userName);
    
    /**
     * 修改用户密码
     * @param userName
     * @param passwd
     */
    public void updateUserPasswd(String userName,String passwd);
}
