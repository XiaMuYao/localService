package com.xiamuyao.localService.filtter;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class LoggingFilter extends AbstractRequestLoggingFilter {

	@Override
	protected boolean shouldLog(HttpServletRequest request) {
		return logger.isDebugEnabled();
	}

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		//logger.debug(message);
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		logger.debug(message);
	}

}
