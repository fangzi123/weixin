package com.micro.rent.dbaccess.dao.myrent;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.micro.rent.common.comm.nmybatis.Page;
import com.micro.rent.dbaccess.entity.myrent.TUpload;



public interface UploadDao {

	List<TUpload> findUploadPaged(Page<TUpload> page);
	
	void insert(TUpload upload);
	
	void updateStatusAfterUploaded(@Param("status")String status, @Param("filePath")String filePath);
}
