package com.benz.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.web.entity.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject,String>{

}
