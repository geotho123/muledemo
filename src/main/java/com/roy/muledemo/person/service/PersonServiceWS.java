package com.roy.muledemo.person.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface PersonServiceWS {
	
	@WebMethod
	@WebResult
	public String getName();
}
