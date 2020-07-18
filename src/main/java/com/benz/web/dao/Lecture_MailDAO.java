package com.benz.web.dao;

import com.benz.web.entity.Lecture_Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lecture_MailDAO extends JpaRepository<Lecture_Mail,Integer> {

}
