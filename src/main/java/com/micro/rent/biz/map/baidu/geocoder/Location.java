package com.micro.rent.biz.map.baidu.geocoder;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("location")
public class Location {
	private BigDecimal lat;

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	private BigDecimal lng;
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
