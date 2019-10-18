package com.xiamuyao.localService.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiRequest {
	private ApiSrcInfo src;
	private ApiDstInfo[]  dst;

	public ApiSrcInfo getSrc() {
		return src;
	}
	public void setSrc(ApiSrcInfo src) {
		this.src = src;
	}
	public ApiDstInfo[] getDst() {
		return dst;
	}
	public void setDst(ApiDstInfo[] dst) {
		this.dst = dst;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
