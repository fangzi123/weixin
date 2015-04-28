package com.micro.rent.dbaccess.dao.aboutus;

import java.util.List;

import com.micro.rent.dbaccess.entity.aboutus.Discount;

public interface DiscountDao {

	List<Discount> selectDiscountInfo();
}
