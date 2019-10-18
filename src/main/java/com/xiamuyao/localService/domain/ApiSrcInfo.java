package com.xiamuyao.localService.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiSrcInfo {
	private String chanel;
	private String system;
	private String id;
	private String sid;
	private String uid;
	private String ip;
	private String opeId;

	public String getChanel() {
		return chanel;
	}
	public void setChanel(String chanel) {
		this.chanel = chanel;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOpeId() {
		return opeId;
	}
	public void setOpeId(String opeId) {
		this.opeId = opeId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}