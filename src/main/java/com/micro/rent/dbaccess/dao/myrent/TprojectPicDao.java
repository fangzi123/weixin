package com.micro.rent.dbaccess.dao.myrent;

import java.util.List;

import com.micro.rent.dbaccess.entity.myrent.TprojectPic;

public interface TprojectPicDao {

	void batchSave(TprojectPic tprojectPic);
	List<TprojectPic> selectProjectPicByProjectId(String projectId);
	/**
	 * 查找某小区的一张图片
	 * @return
	 * @author wff
	 */
	String findOneProPicByComName(String communityName);
}
