package com.xiamuyao.localService.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiDstInfo {
	private String service;
	private String version;
	private String id;
	private Object params;

	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getParams() {
		return params;
	}
	public void setParams(Object params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
