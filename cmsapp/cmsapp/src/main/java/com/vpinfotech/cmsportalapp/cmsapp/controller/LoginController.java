package com.vpinfotech.cmsportalapp.cmsapp.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vpinfotech.cmsportalapp.cmsapp.common.service.RestApiEndpointService;
import com.vpinfotech.cmsportalapp.cmsapp.model.User;

@RestController
@RequestMapping(value="/module")
public class LoginController {
	
	Logger logger= LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	RestApiEndpointService restApiEndpointService;
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method= RequestMethod.POST, value="/login")
	public <HttpResponse> ResponseEntity<ObjectNode> isUserAuthorize(@RequestBody User user){
		ResponseEntity<ObjectNode> responseEntity=null;
		String loginServiceEndPoint=restApiEndpointService.getLoginService();
		logger.info("LoginController: isUserAuthorize()->Hello Ujjawal");
		try{
		
			JsonNodeFactory nodeFactory= new JsonNodeFactory(true);
			ObjectNode request= nodeFactory.objectNode();
			HttpHeaders headers = new HttpHeaders();			
			HttpResponse response;			
			String apiurl=loginServiceEndPoint+"/user/login";
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        request.put("userId", user.getUserId());
	        request.put("password", user.getPassword());
	        HttpEntity<ObjectNode> requestEntity = new HttpEntity<ObjectNode>(request, headers);
			ResponseEntity<ObjectNode>res= restTemplate.exchange(apiurl, HttpMethod.POST, requestEntity, ObjectNode.class);
			response=(HttpResponse) res.getBody();
			responseEntity= new ResponseEntity<ObjectNode>( (ObjectNode) response, HttpStatus.OK);
			logger.info("Response: "+response);
			
		}catch(Exception ex){
			logger.info("LoginController: isUserAuthorize()->Unable to Consume Rest API....");
			responseEntity= new ResponseEntity<ObjectNode>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

}
