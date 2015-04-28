package com.micro.rent.biz.map.service;

import java.util.List;
import java.util.Map;

import com.micro.rent.biz.map.baidu.MapPoint;

public interface MapService {

	MapPoint getPoint(String address,String city);
	
	Map<String,String> getPlace(MapPoint mapPoint);
	
	String crtStaticMapUrl(List<MapPoint> lstMark,MapPoint currPoint);
	
	String doLeastTimeBetweenTwoPoint(DirectionReqParam reqParam);
	
	
}
