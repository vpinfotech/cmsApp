package com.vpinfotech.cmsportalapp.cmsapp.common.service.Impl;

import java.util.Properties;

import com.vpinfotech.cmsportalapp.cmsapp.common.entity.PropertyLoaderUtil;
import com.vpinfotech.cmsportalapp.cmsapp.common.service.RestApiEndpointService;

public class RestApiEndpointServiceImpl implements RestApiEndpointService {
	
	private Properties restApi;
	
	public RestApiEndpointServiceImpl(){
		this.restApi=PropertyLoaderUtil.getProperties("restService.properties");
	}

	@Override
	public String getLoginService() {
		return restApi.getProperty("COM.CMSP.LOGIN.USER");
	}

}
