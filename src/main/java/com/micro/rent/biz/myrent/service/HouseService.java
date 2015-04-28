
package com.micro.rent.biz.myrent.service;

import java.math.BigDecimal;
import java.util.List;

import com.micro.rent.biz.myrent.vo.HouseWrapVo;
import com.micro.rent.biz.personal.vo.HouseVo;
import com.micro.rent.dbaccess.entity.myrent.HouseInfo;
import com.micro.rent.dbaccess.entity.myrent.ThousePic;


/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 * @author dell
 * @date 2014-9-9
 * @version TODO
 */
public interface HouseService {

	HouseInfo findBaseHouseInfoByHouseId(String houseId);
	
	/**
	 * 公寓图片
	 * @param houseId
	 * @return
	 */
	List<ThousePic> findHousePicListByHouseId(String houseId);
	
	/**
	 * 公寓详情
	 * @param houseId
	 * @return
	 */
	HouseWrapVo findHouseInfoByHouseId(String houseId);
	
	//String getDuration(BigDecimal lat,BigDecimal lon,BigDecimal wpLat,BigDecimal wpLon);
	/**
	 *  查找一套公寓下 所有房屋的图片信息
	 * @param projectId
	 * @return
	 * @author wff
	 */
	List<HouseWrapVo> findHousesInOneProject(String projectId);
	/**
	 * 房源入库 
	 * @throws Exception
	 * @author wff
	 */
	void batchSaveHouse(HouseInfo houseInfo) throws Exception;
	
	/**
	 * @deprecated: 检索推荐房源
	 * @return 推荐房源列表
	 * @throws Exception
	 * @date 2014.12.6
	 * @author zbb
	 */
	List<HouseInfo> searchRecommendHouseList() throws Exception;
	
	/**
	 * @deprecated: 检索指定位置附近两套房源
	 * @param lat: 纬度
	 * @param lng: 经度
	 * @return 附近房源列表
	 * @throws Exception
	 * @date 2014.12.6
	 * @author zbb
	 */
	public List<HouseInfo> searchNearbyHouses(double lat, double lng) throws Exception;
}
