package com.benz.web.dao;

import com.benz.web.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureDAO extends JpaRepository<Lecture,Integer> {
}
