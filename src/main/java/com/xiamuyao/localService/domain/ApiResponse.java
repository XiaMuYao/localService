package com.xiamuyao.localService.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiResponse {
	private String service;
	private String version;
	private String id;
	private ApiResult result;
	private Object responseData;
	private ApiErrorDetail errorDetail;

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
	public ApiResult getResult() {
		return result;
	}
	public void setResult(ApiResult result) {
		this.result = result;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public ApiErrorDetail getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(ApiErrorDetail errorDetail) {
		this.errorDetail = errorDetail;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
