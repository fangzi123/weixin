package com.micro.rent.common.comm;

import java.io.Serializable;

import com.micro.rent.common.support.ApplicationContextUtil;
import com.micro.rent.common.support.CacheManagerHelper;


/**
 * @Description 系统缓存枚举类
 * @author 
 * @date 2013-4-10
 * @version 1.0
 */
public enum ECache {	
	/**
	 * 
	 */
	CACHE_XSTREAM ("cache.xstream");
	
		
	ECache(String code){
		this.code = code;
	}
	
	private final String code;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @Description 通过缓存键值获取当前枚举缓存中的缓存值
	 * @param key 
	 * @return
	 * @author 
	 */
	public<T> T getCacheEntity(Serializable key){	
		return (T)cacheManagerHelper.get(getCode(), key);
	}
	
	/**
	 * @Description 获取当前枚举缓存并进行缓存设置
	 * @param key
	 * @param value
	 * @author 
	 */
	public void putCacheEntity(Serializable key, Object value){
		cacheManagerHelper.put(getCode(), key, value);
	}
	
	public void removeCache() {
		cacheManagerHelper.clearCache(getCode());
	}
	
	private  static CacheManagerHelper cacheManagerHelper = ApplicationContextUtil.getBean(CacheManagerHelper.class);
}
