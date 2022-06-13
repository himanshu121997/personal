package com.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@GetMapping("/studentServiceFallBack")
	public String studentServiceFallBack() {
		return "student service failed";
	}

	@GetMapping("/schoolServiceFallBack")
	public String schoolServiceFallBack() {
		return "school service failed";
	}

}
