package com.eci.training.web;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceBean {
	
	
	@RolesAllowed("ADMIN")
	public String superSensitiveOp() {
		return "sensitive data";
	}

}

