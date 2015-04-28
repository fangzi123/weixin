package com.micro.rent.common.comm.mybatis;

public abstract class Dialect {

	public static enum Type{
		MYSQL,
		ORACLE
	} 
	
	public abstract String getLimitString(String sql, int offset, int limit);
}
