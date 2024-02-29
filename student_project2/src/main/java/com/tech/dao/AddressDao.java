package com.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.dto.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

}
