
package com.micro.rent.biz.myrent;

import com.micro.rent.dbaccess.entity.myrent.HouseInfo;

import java.math.RoundingMode;

/**
 * @Description: 构建类
 * 
 * @author dell
 * @date 2014-8-28
 * @version 1.0
 */
public class HouseInfoBuilder {

	public static void reSetFloor(HouseInfo houseInfo) {
		
		if (houseInfo.getFloor() != null) {
			houseInfo.setFloor(houseInfo.getFloor().setScale(0,RoundingMode.DOWN));
		}
		if (houseInfo.getTotalFloor() != null) {
			houseInfo.setTotalFloor(houseInfo.getTotalFloor().setScale(0,RoundingMode.DOWN));
		}
	}
}
