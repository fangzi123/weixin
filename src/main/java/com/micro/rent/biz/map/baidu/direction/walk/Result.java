
package com.micro.rent.biz.map.baidu.direction.walk;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @Description: 
 * 
 * @author dell
 * @date 2014-8-5
 * @version 
 */
@XStreamAlias("result")
public class Result {

	private Route routes;
	
	private Origin origin;
	
	private Destination destination;

	public Route getRoutes() {
		return routes;
	}

	public void setRoutes(Route routes) {
		this.routes = routes;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
}
