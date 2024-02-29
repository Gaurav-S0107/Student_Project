package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.Student;
import com.tech.service.StudentService;

@RestController
@RequestMapping("/service1")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	public StudentController() {
		System.out.println("Inside StudentController");
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
	@PostMapping("/createOne")
	public Student createOne(@RequestBody Student student) {
		return studentService.createOne(student);
	}
	
	@PostMapping("/create")
	public List<Student> createStudent(@RequestBody List<Student> student) {
		System.out.println("Inside create Student");
		return studentService.createStudent(student);
	}
	
	@GetMapping("/findById/{id}")
	public Student findById(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	@GetMapping("/findByName/{name}")
	public List<Student> findByName(@PathVariable String name) {
		return studentService.findByname(name);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteById(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	
}
