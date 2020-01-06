package com.spideron.rest.annotations.bean;

import javax.ws.rs.QueryParam;

public class ResourceAnnotationBeans {
	
	private @QueryParam("start")int start;
	private @QueryParam("size")int size;
	
	
	public ResourceAnnotationBeans() {
		super();
	}
	public ResourceAnnotationBeans(int start, int size) {
		super();
		this.start = start;
		this.size = size;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
