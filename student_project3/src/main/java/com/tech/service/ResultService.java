package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.ResultDao;

import com.tech.dto.Student;

@Service
public class ResultService {

	@Autowired
	ResultDao resultDao;

}
