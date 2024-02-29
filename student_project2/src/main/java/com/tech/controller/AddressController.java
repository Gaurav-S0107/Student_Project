package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.Address;
import com.tech.dto.Student;
import com.tech.service.AddressService;


@RestController
@RequestMapping("/service2")
public class AddressController {
	
	@Autowired
	AddressService addressService;

	public AddressController() {
		System.out.println("Inside AddressController");
	}
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
	@PostMapping("/createAddress")
	public List<Address> createStudent(@RequestBody List<Address> address) {
		return addressService.createAddress(address);
	}
	
	@GetMapping("/getAllAddress")
	public List<Address> getAllStudent() {
		return addressService.getAllAddress();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") int id) {
		addressService.deleteAddress(id);
	}
	
	@PostMapping("/saveStudentData")	
	public String saveStudentData(@RequestBody Student s1)
	{
		System.out.println("inside 8082-saveStudentData()");
		if(s1.getId()>0)
		{
			return "data saved in db";
		}else {
			return "invalid data";
		}
	}
	
	
	
}
