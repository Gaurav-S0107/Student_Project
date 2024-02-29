package com.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.dto.Result;
import com.tech.dto.Student;

@Repository
public interface ResultDao extends JpaRepository<Result, Integer> {

}
