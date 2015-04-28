package com.micro.rent.dbaccess.dao.myrent;

import java.util.List;
import java.util.Map;

import com.micro.rent.biz.myrent.vo.MatchResultVo;
import com.micro.rent.biz.myrent.vo.MyRentQueryVo;
import com.micro.rent.dbaccess.entity.myrent.TProject;
import com.micro.rent.dbaccess.entity.myrent.TprojectPic;

public interface MyRentalDao {

	List<MatchResultVo> selectProjectByQueryVo(MyRentQueryVo queryVo);
	
	List<MatchResultVo> selectAllProject();
	
	List<MatchResultVo> selectCoverProject(Map map);

	List<MatchResultVo> selectHouseByQueryVo(MyRentQueryVo queryVo);
	/**
	 * 按条件查询房源    算距离
	 * @author wff
	 * @param queryVo
	 * @return
	 */
	List<MatchResultVo> findHouseByQueryVo(MyRentQueryVo queryVo);

	List<MatchResultVo> selectOneProjectByQueryVo(MyRentQueryVo queryVo);
	/**
	 * 根據houseid查詢房源列表
	 * @author wff
	 * @param houseIds
	 * @return
	 */
	List<MatchResultVo> findHousesByHouseIds(List<String> houseIds);

}
