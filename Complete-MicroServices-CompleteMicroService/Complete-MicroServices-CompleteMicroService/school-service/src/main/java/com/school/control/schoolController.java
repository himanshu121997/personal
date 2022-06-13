package com.school.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.school.model.school;
import com.school.service.schoolService;

@RestController
@RequestMapping("/school")
public class schoolController {
	
	private static final Logger logger = LoggerFactory.getLogger(schoolController.class);

	@Autowired
	private schoolService service;
	
	@Autowired
	RestTemplate rest;

	@PostMapping("/addSchool")
	public String add(school s) {
		return service.addSchool(s);
	}
	
	@GetMapping("/home")
	public String home() {
		return "hello";
	}

	@GetMapping("/school")
	public List<school> list() {
		logger.info("inside get method of school controller");
		List<school> l = service.findAll(rest);
		logger.info("final response: " + l);
		return l;
	}

	@GetMapping("delete/{id}")
	public List<school> delete(@PathVariable int id) {
		return service.removeById(id);
	}

	@GetMapping("school/{id}")
	public school findById(@PathVariable int id) {
		return service.findById(id);
	}
}
