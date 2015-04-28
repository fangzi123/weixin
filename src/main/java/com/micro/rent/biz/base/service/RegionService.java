package com.micro.rent.biz.base.service;

import java.util.List;

import com.micro.rent.dbaccess.entity.base.RegionInfo;

public interface RegionService {

	List<RegionInfo> findReginsByParentCodeAndRegionLevel(int parentCode,
			int regionLevel);
	
	List<RegionInfo> findDirectCityByGovnmentByParentId(int parentId);
	List<RegionInfo> findReginsByParentId(int parentId);
	List<RegionInfo> findReginsByRegionCode(String regionCode);
}
