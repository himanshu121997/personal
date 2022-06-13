package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.school.model.school;
import com.school.repo.schoolRepo;

@Service
public class schoolService {

	@Autowired
	private schoolRepo repo;

	public String addSchool(school s) {
		return repo.addSchool(s);
	}

	public List<school> removeById(int id) {
		return repo.removeSchoolById(id);
	}

	public List<school> findAll(RestTemplate rest) {
		return repo.findAll(rest);
	}

	public school findById(int id) {
		return repo.findById(id);
	}

}
