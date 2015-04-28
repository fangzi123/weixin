package com.micro.rent.dbaccess.dao.myrent;

import java.util.List;
import com.micro.rent.dbaccess.entity.myrent.ThousePic;


public interface ThousePicDao {

	void batchSave(ThousePic thousePic);

	List<ThousePic> selectHousePicListByHouseId(String houseId);
	
}
