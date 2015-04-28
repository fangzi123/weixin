package com.micro.rent.dbaccess.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.micro.rent.dbaccess.entity.base.RegionInfo;

public interface RegionDao {

	/**
	 * 根据父级编码和地区等级查询地区信息
	 * @param parentCode
	 * @param regionLevel
	 * @return
	 */
	List<RegionInfo> findReginsByParentCodeAndRegionLevel(@Param("parentId")int parentId,
			@Param("regionLevel")int regionLevel);
	
	List<RegionInfo> findReginsByParentId(@Param("parentId")int parentId);
	
	List<RegionInfo> findDirectCityByGovnmentByParentId(@Param("parentId")int parentId);
	
	/**
	 * 根据行政区划代码查询地区信息
	 * @param regionCode
	 * @return
	 */
	List<RegionInfo> findReginsByRegionCode(@Param("regionCode")String regionCode);
}
