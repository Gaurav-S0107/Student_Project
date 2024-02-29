package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.AddressDao;
import com.tech.dto.Address;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	public List<Address> createAddress(List<Address> address) {
		return addressDao.saveAll(address);
	}
	
	public List<Address> getAllAddress() {
		return addressDao.findAll();
	}
	
	public void deleteAddress(int id) {
		addressDao.deleteById(id);
	}
}
