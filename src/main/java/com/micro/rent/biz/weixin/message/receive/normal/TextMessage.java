package com.micro.rent.biz.weixin.message.receive.normal;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class TextMessage extends BaseOrdinaryMessage {
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
