package com.eci.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	SomeServiceBean service;
	
	@GetMapping("/sample")
	public String sampleData() {
		return "Sample Data";
	}
	
	@GetMapping("/admin/sample")
	public String adminData() {
		return "admin Data";
	}
	
	@GetMapping("/sensitive")
	public String sensitiveMethod() {
		String data = null;
		try {
			data = service.superSensitiveOp();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			data = "Not Allowed!!!";
		}
		return data;
	}

}
