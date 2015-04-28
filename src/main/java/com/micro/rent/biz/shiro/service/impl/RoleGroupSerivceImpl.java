package com.micro.rent.biz.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.rent.biz.shiro.service.RoleGroupSerivce;
import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.dao.RoleGroupDao;
import com.micro.rent.dbaccess.dao.SetFuncRoleDao;
import com.micro.rent.dbaccess.dao.SetResourceRoleDao;
import com.micro.rent.dbaccess.dao.SetRgroupFroleDao;
import com.micro.rent.dbaccess.dao.SetRgroupRroleDao;
import com.micro.rent.dbaccess.dao.SetRoleGroupDao;
import com.micro.rent.dbaccess.entity.RoleGroup;
import com.micro.rent.dbaccess.entity.SetFuncRole;
import com.micro.rent.dbaccess.entity.SetResourceRole;
import com.micro.rent.dbaccess.entity.SetRgroupFrole;
import com.micro.rent.dbaccess.entity.SetRgroupRrole;
import com.micro.rent.dbaccess.entity.SetRoleGroup;

@Service("roleGroupSerivce")
public class RoleGroupSerivceImpl implements RoleGroupSerivce {

	@Override
	public String queryGroupSeq() {
		return setRoleGroupDao.getSequences();
	}
	
	
	@Override
	public void queryPaged(Page<RoleGroup> page) {
		// 分页结果集
		List<RoleGroup> list = roleGroupDao.queryPaged(page);
		page.setResults(list);
	}

	@Override
	public void create(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList) {
		setRoleGroupDao.insert(roleGroup);
		if(frList != null && !frList.isEmpty()){
			for(SetRgroupFrole rgroupf : frList){
				setRgroupFroleDao.insert(rgroupf);
			}
		}
		if(rrList != null && !rrList.isEmpty()){
			for(SetRgroupRrole rgroupr : rrList){
				setRgroupRroleDao.insert(rgroupr);
			}
		}
	}
	
	@Override
	public void update(SetRoleGroup roleGroup, List<SetRgroupFrole> frList, List<SetRgroupRrole> rrList, String rgroupId) {
		setRoleGroupDao.updateByPrimaryKeySelective(roleGroup);
		setRgroupFroleDao.deleteByGroupId(rgroupId);
		setRgroupRroleDao.deleteByGroupId(rgroupId);
		if(frList != null && !frList.isEmpty()){
			for(SetRgroupFrole rgroupf : frList){
				setRgroupFroleDao.insert(rgroupf);
			}
		}
		if(rrList != null && !rrList.isEmpty()){
			for(SetRgroupRrole rgroupr : rrList){
				setRgroupRroleDao.insert(rgroupr);
			}
		}
	}
	
	@Override
	public void delete(String rgroupId) {
		setRoleGroupDao.deleteByPrimaryKey(rgroupId);
		setRgroupFroleDao.deleteByGroupId(rgroupId);
		setRgroupRroleDao.deleteByGroupId(rgroupId);
	}

	@Override
	public List<SetFuncRole> queryFrAll() {
		return setFuncRoleDao.queryAll();
	}

	@Override
	public List<SetResourceRole> queryRrAll() {
		return setResourceRoleDao.queryAll();
	}
	
	
	@Override
	public List<SetFuncRole> queryFCandidateResource(String rgroupId) {
		return setFuncRoleDao.queryCandidateResource(rgroupId);
	}
	@Override
	public List<SetFuncRole> queryFSelectedResource(String rgroupId) {
		return setFuncRoleDao.querySelectedResource(rgroupId);
	}
	
	@Override
	public List<SetResourceRole> queryRCandidateResource(String rgroupId) {
		return setResourceRoleDao.queryCandidateResource(rgroupId);
	}
	@Override
	public List<SetResourceRole> queryRSelectedResource(String rgroupId) {
		return setResourceRoleDao.querySelectedResource(rgroupId);
	}
	
	
	@Autowired
	private RoleGroupDao roleGroupDao;
	@Autowired
	private SetRoleGroupDao setRoleGroupDao;
	@Autowired
	private SetRgroupFroleDao setRgroupFroleDao;
	@Autowired
	private SetRgroupRroleDao setRgroupRroleDao;
	@Autowired
	private SetFuncRoleDao setFuncRoleDao;
	@Autowired
	private SetResourceRoleDao setResourceRoleDao;

}
