package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.StudentDao;
import com.tech.dto.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;

	public List<Student> createStudent(List<Student> student) {

		return studentDao.saveAll(student);
	}
	
	public Student findById(int id) {
		
		Optional<Student> std = studentDao.findById(id);
		Student student = std.get();
		
		return student;
	}
	
	

	public List<Student> getAllStudent() {
		return studentDao.findAll();
	}
	
	public void deleteStudent(int id) {
		studentDao.deleteById(id);
	}

	public Student createOne(Student student) {
		
		return studentDao.save(student);
	}

	public Student updateStudent(Student student) {
		int id = student.getId();
		
		Optional<Student> existingdata = studentDao.findById(id);
		Student s1 = existingdata.get();
		
		Student studentToUpdate = new Student();
		studentToUpdate.setId(id);
		
		if (student.getName()!=null) {
			studentToUpdate.setName(student.getName());
		}else {
			studentToUpdate.setName(s1.getName());
		}
		if (student.getEmail()!=null) {
			studentToUpdate.setEmail(student.getEmail());
		}else {
			studentToUpdate.setEmail(s1.getEmail());
		}
		if (student.getAge()>0) {
			studentToUpdate.setAge(student.getAge());
		}else {
			studentToUpdate.setAge(s1.getAge());
		}
		return studentDao.save(studentToUpdate);
	}

	public List<Student> findByname(String name) {
		
		return studentDao.findByName(name);
	}


	
	

}
