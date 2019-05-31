package com.vpinfotech.cmsportalapp.cmsapp.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vpinfotech.cmsportalapp.cmsapp.model.User;

@RestController
@RequestMapping(value="/module")
public class LoginController {
	
	Logger logger= LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method= RequestMethod.GET, value="/login")
	public <HttpResponse> ResponseEntity<ObjectNode> isUserAuthorize(@RequestBody HttpRequest request, HttpResponse response){
		ResponseEntity<ObjectNode> responseEntity=null;
		String url="localhost:8772/cmsportal/user/login";
		
		try{
			JsonNodeFactory nodeFactory= new JsonNodeFactory(true);
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> requestEntity = new HttpEntity<String>(nodeFactory.objectNode().toString(), headers);
			responseEntity= restTemplate.exchange(url, HttpMethod.GET, requestEntity, ObjectNode.class);
			response=(HttpResponse) responseEntity.getBody();
			logger.info("Response: "+response);
			
		}catch(Exception ex){
			logger.info("LoginController: isUserAuthorize()->Unable to Consume Rest API....");
		}
		return responseEntity;
	}

}
