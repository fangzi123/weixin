package com.micro.rent.dbaccess.dao.myrent;

import java.util.List;

import com.micro.rent.biz.myrent.vo.TrafficVo;
import com.micro.rent.dbaccess.entity.myrent.ThouseTraffic;

public interface ThouseTrafficDao {

	void batchSave(ThouseTraffic tra);

	List<TrafficVo> selectHouseTrafficByProjectId(String projectId);

}
