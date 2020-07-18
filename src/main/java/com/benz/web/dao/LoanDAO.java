package com.benz.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.web.entity.StudentLoan;

@Repository
public interface LoanDAO extends JpaRepository<StudentLoan,String>{

	StudentLoan findLoanByLoanNumber(int loan_num);
}
