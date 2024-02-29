package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.dto.Student;
import com.tech.exception.ResourceNotFound;
import com.tech.service.ResultService;

@RestController
@RequestMapping("/service3")
public class ResultController {
	@Value("${base_url_6061}")
	String url1;
	@Value("${base_url_6062}")
	String url2;

	@Autowired
	ResultService resultService;

	@Autowired
	RestTemplate restTemplate;

	public ResultController() {
		System.out.println("Inside StudentController");
	}

	@GetMapping("/test")
	public String test() {
		return "hello";
	}

	/*
	 * @GetMapping("/test2") public String test2() { String url = url2 + "/test";
	 * System.out.println(url);
	 * 
	 * ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, null,
	 * String.class); System.out.println(res.getBody()); return res.getBody(); }
	 * 
	 * @GetMapping("/test3") public List<Student> getData() { String url = url1 +
	 * "/getAllStudent";
	 * 
	 * ResponseEntity<List<Student>> res = restTemplate.exchange(url,
	 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() { });
	 * System.out.println(res.getStatusCodeValue());
	 * System.out.println(res.getBody()); return res.getBody(); }
	 */

//	create new Data

	@PostMapping("/createData")
	public Student createData(@RequestBody Student student) {
		String final_url1 = url1 + "/createOne";
		System.out.println(final_url1);
//		
		HttpEntity<Student> s1 = new HttpEntity<Student>(student);
//for postForEntity		1=url,2=input , 3= Output
		ResponseEntity<Student> response = restTemplate.postForEntity(final_url1, s1, Student.class);

		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}
	
//	with Exception Handled
	
	@PostMapping("/createData1")
	public Student createData1(@RequestBody Student student) {
		String final_url1 = url1 + "/createOne";
		System.out.println(final_url1);

		HttpEntity<Student> s1 = new HttpEntity<Student>(student);
//for postForEntity		1=url,2=input , 3= Output
		ResponseEntity<Student> response = null;
		try {
			response = restTemplate.postForEntity(final_url1, s1, Student.class);
		} catch (Exception e) {
			System.out.println("In catch Block" + e);
			throw new ResourceNotFound(final_url1 + " is not working");
		}
		

		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}

//	/findById/{id}
	@GetMapping("/findById/{id}")
	public Student findbyId(@PathVariable int id) {
		String final_url1 = url1 + "/findById/" + id;
		System.out.println(final_url1);
		ResponseEntity<Student> response = restTemplate.getForEntity(final_url1, Student.class);

		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}

//	findByName
	@GetMapping("/findByName/{name}")
	public String findbyName(@PathVariable String name) {
		String final_url1 = url1 + "/findByName/" + name;
		System.out.println(final_url1);
		ResponseEntity<String> response = restTemplate.getForEntity(final_url1, String.class);

		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}

//findByName second method
	@GetMapping("/findByName1/{name}")
	public List<Student> findbyName1(@PathVariable String name) {
		String final_url1 = url1 + "/findByName/" + name;
		System.out.println(final_url1);
		ResponseEntity<List<Student>> response = restTemplate.exchange(final_url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Student>>() {
				});

		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}

//	deleteById

	@DeleteMapping("/deleteById/{id}")
	public Void deleteById(@PathVariable int id) {
		String final_url1 = url1 + "/deleteStudent/" + id;
		System.out.println(final_url1);
		ResponseEntity<Void> response = restTemplate.exchange(final_url1, HttpMethod.DELETE, null, void.class);
		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getBody();
	}

//	
	@DeleteMapping("/deleteById1/{id}")
	public int deleteById1(@PathVariable int id) {
		String final_url1 = url1 + "/deleteStudent/" + id;
		System.out.println(final_url1);
		ResponseEntity<Void> response = restTemplate.exchange(final_url1, HttpMethod.DELETE, null, Void.class);
		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		return response.getStatusCodeValue();
	}
	
	
//	Trial
	@PostMapping("/findById3/{id}")
	public String validate(@PathVariable int id) {
		String final_url1 = url1 + "/findById/" + id;
		System.out.println(final_url1);
		
		Student studentReceivedData = null;
		
		try {
			studentReceivedData = restTemplate.getForObject(final_url1,Student.class);
		} catch (Exception e) {
			System.out.println("In catch block " + e);
			studentReceivedData = new Student();
		}
		
		String final_url2 = url2 + "/saveStudentData";
		
		HttpEntity<Student> input = new HttpEntity<Student>(studentReceivedData);
		
		ResponseEntity<String> response = restTemplate.exchange(final_url2,HttpMethod.POST, input, String.class);
		System.out.println(response);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody()); response.getBody();
		return response.getBody();
		/*
		 * ResponseEntity<Void> response = restTemplate.exchange(final_url1,
		 * HttpMethod., null, Void.class); System.out.println(response);
		 * System.out.println(response.getStatusCodeValue());
		 * System.out.println(response.getBody()); return response.getStatusCodeValue();
		 */
	}

}
