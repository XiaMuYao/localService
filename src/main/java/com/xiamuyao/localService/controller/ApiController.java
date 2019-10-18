package com.xiamuyao.localService.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiamuyao.localService.domain.ApiRequest;
import com.xiamuyao.localService.domain.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/")
@RestController
public class ApiController {

	private Logger logger = LoggerFactory.getLogger(ApiController.class);
	private ObjectMapper objectMapper = new ObjectMapper();

	@Value("${app.stub.folder}")
	private String stubFolder;

	@SuppressWarnings("unchecked")
	@RequestMapping("/ipo/**")
	public Map<String,Object> api(@RequestHeader Map<String, String> headers, 
			HttpServletRequest req, HttpServletResponse resp) {
//		logger.debug("ApiRequest: " + apiRequest);
//		if (apiRequest == null ) {
//			logger.error("ApiRequest is null.");
//			return null;
//		}
//		if (apiRequest.getSrc() == null) {
//			logger.error("ApiRequest.src is null.");
//			return null;
//		}
//		if (id == null) {
//			logger.error("ApiRequest.src.id is null.");
//			return null;
//		}
		String id = headers.get("id");
		Map<String,Object> response = null;
		File jsonFile = new File(stubFolder + File.separator + headers.get("id") + ".json");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(id.equals("login")) {
			logger.debug("Api: " + id);
		}
		if (jsonFile.exists()) {
			try {
				response = objectMapper.readValue(jsonFile, new TypeReference<Map<String,Object>>(){});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
//			String methodName = StringUtils.replace(id, ".", "");
//			Method method = ReflectionUtils.findMethod(this.getClass(), methodName, Map.class, ApiRequest.class, HttpServletRequest.class, HttpServletResponse.class);
//			Object obj = ReflectionUtils.invokeMethod(method, this, headers, apiRequest, req, resp);
//			if (obj instanceof List) {
//				response = (List<ApiResponse>) obj;
//			}
		}
		logger.debug("ApiResponse: " + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public ApiResponse api2(@RequestHeader Map<String, String> headers,
							@RequestBody(required=false) ApiRequest apiRequest,
							HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("ApiRequest: " + apiRequest);
		if (apiRequest == null ) {
			logger.error("ApiRequest is null.");
			return null;
		}
		if (apiRequest.getSrc() == null) {
			logger.error("ApiRequest.src is null.");
			return null;
		}
		String id = apiRequest.getSrc().getId();
		if (id == null) {
			logger.error("ApiRequest.src.id is null.");
			return null;
		}
		ApiResponse response = null;
		File jsonFile = new File(stubFolder + File.separator + id + ".json");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(id.equals("login")) {
			logger.debug("Api: " + id);
		}
		if (jsonFile.exists()) {
			try {
				response = objectMapper.readValue(jsonFile, new TypeReference<ApiResponse>(){});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
//			String methodName = StringUtils.replace(id, ".", "");
//			Method method = ReflectionUtils.findMethod(this.getClass(), methodName, Map.class, ApiRequest.class, HttpServletRequest.class, HttpServletResponse.class);
//			Object obj = ReflectionUtils.invokeMethod(method, this, headers, apiRequest, req, resp);
//			if (obj instanceof List) {
//				response = (List<ApiResponse>) obj;
//			}
		}
		logger.debug("ApiResponse: " + response);
		return response;
	}
	public List<ApiResponse> login(Map<String, String> headers,  ApiRequest apiRequest, HttpServletRequest req, HttpServletResponse resp) {

		// TODO
		Map<String, Object> assetsInfo = new HashMap<>();
		assetsInfo.put("depositAmount", 99999);
		assetsInfo.put("profitLoss", 888);
		assetsInfo.put("availablePoint", 77777);
		assetsInfo.put("restrictPointDate", "2019/10/11");
		assetsInfo.put("tpointState", "1");
		assetsInfo.put("tpointResponseCode", "CD");
		assetsInfo.put("restrictPointSum", 6666);

		Map<String, Object> responseData = new HashMap<>();
		responseData.put("assetsInfo", assetsInfo);

		List<ApiResponse> response = new ArrayList<>();
		ApiResponse res = new ApiResponse();
//		res.setService("account");
//		res.setVersion("1.0.0");
//		res.setId("login");
//		res.setResult(ApiResult.OK);
		response.add(res);
		return response;

	}

}
