package com.student.control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.student;

@RestController
@RequestMapping("/student")
public class control {
	
	private static final Logger logger = LoggerFactory.getLogger(control.class);

	@Value("${hello.msg}")
	String msg;

	@GetMapping("/student")
	public List<student> find() {
		System.out.println("msg: " + msg);
		logger.info("inside get method of student controller");
		List<student> l = new ArrayList<student>();
		student s = new student("1", "Himanshu");
		l.add(s);
		return l;
	}
}
