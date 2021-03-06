
package com.micro.rent.dbaccess.dao.personal;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.micro.rent.biz.personal.vo.HouseVo;
import com.micro.rent.dbaccess.entity.personal.Order;

/**
 * @Description: 
 * 
 * @author dell
 * @date 2014-8-28
 * @version 1.0
 */
public interface MyOrderDao {

	void addPreOrder(Order order);
	
	List<Order> queryOrderList(String weixinId);
	
	List<Order> queryOrderByHouseIdAndWeixinId(@Param("houseId")String houseId, @Param("weixinId")String weixinId);
	
	List<HouseVo> queryOrderHouseList(String weixinId);

	Integer queryOrderCountByHouseIdAndWeixinIdAndOrderDate(@Param("houseId")String houseId, @Param("weixinId")String weixinId, @Param("orderDate")String orderDate);
}
