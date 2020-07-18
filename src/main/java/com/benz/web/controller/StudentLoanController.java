package com.benz.web.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.web.entity.Branch;
import com.benz.web.entity.StudentLoan;
import com.benz.web.services.StudentLoanService;

@RestController
@RequestMapping("/loan")
public class StudentLoanController {
	
	@Autowired
	StudentLoanService loan_service;
	
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PostMapping("/save")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void saveLoan(@RequestBody StudentLoan loan) throws Exception
	{
		if(!loan.getLoanType().trim().isEmpty() && loan.getLoanAmount()!=0 &&
				loan.getMonthlyInstallment()!=0)
			loan_service.saveLoan(loan);
		else
			 throw new NullPointerException();
	}
	
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PostMapping("/oneToOne")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 public void oneToOne_Uni(@RequestBody StudentLoan loan)
	 {
		if(!loan.getLoanType().trim().isEmpty() && loan.getLoanAmount()!=0 &&
				loan.getMonthlyInstallment()!=0)
			loan_service.oneToOne_Uni(loan);
		else
			 throw new NullPointerException();
	 }
	
	@GetMapping("/all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<StudentLoan> getLoans()
	{
		return loan_service.getLoans();
	}
	
	@GetMapping("/find")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public StudentLoan getLoan(@RequestBody StudentLoan loan)
	{
		if(loan.getLoanNumber()!=0)
			return loan_service.getLoan(loan);
		else
			throw new NullPointerException();
	}

	@GetMapping("/manyToOne")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void manyToOne()
	{

		loan_service.manyToOne();
	}

	@GetMapping("/manyToMany")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void manyToMany()
	{
		loan_service.manyToMany();
	}


}
