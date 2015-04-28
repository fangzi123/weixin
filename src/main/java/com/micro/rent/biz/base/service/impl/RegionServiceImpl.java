package com.micro.rent.biz.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.rent.biz.base.service.RegionService;
import com.micro.rent.dbaccess.dao.base.RegionDao;
import com.micro.rent.dbaccess.entity.base.RegionInfo;

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionDao regionDao;

	public List<RegionInfo> findReginsByParentCodeAndRegionLevel(
			int parentCode, int regionLevel) {

		return regionDao.findReginsByParentCodeAndRegionLevel(parentCode,
				regionLevel);
	}

	public List<RegionInfo> findReginsByParentId(int parentId) {
		return regionDao.findReginsByParentId(parentId);
	}

	public List<RegionInfo> findDirectCityByGovnmentByParentId(int parentId) {
		return regionDao.findDirectCityByGovnmentByParentId(parentId);
	}
	
	public List<RegionInfo> findReginsByRegionCode(String regionCode) {
		return regionDao.findReginsByRegionCode(regionCode);
	}
}
