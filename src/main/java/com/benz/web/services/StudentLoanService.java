package com.benz.web.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.web.dao.LoanDAO;
import com.benz.web.entity.Branch;
import com.benz.web.entity.StudentLoan;
import com.benz.web.exception.DataNotFoundException;

@Service
public class StudentLoanService {
	
	@Autowired
	LoanDAO loan_dao;

	public void saveLoan(StudentLoan loan) throws Exception
	{
		loan_dao.save(loan);
		System.out.println("Loan has been saved");
	}
	
	public List<StudentLoan> getLoans()
	{
		List<StudentLoan> loans=loan_dao.findAll();
		
		if(loans.size()!=0)
			return loans;
		else
			throw new DataNotFoundException("Data Not Available");
	}
	
	public StudentLoan getLoan(StudentLoan loan)
	{
		StudentLoan n_loan=loan_dao.findLoanByLoanNumber(loan.getLoanNumber());
		
		if(n_loan!=null)
			return n_loan;
		else
			throw new DataNotFoundException("Data Not Available");
		
	}
	
	public void oneToOne_Uni(StudentLoan loan)
    {
        
        Branch branch=new Branch();
        branch.setBranchCode("AG65323");
        branch.setManagerName("Mr. Deshan");
        branch.setCity("Agalawatta");
        branch.setTeleNo("083-45678654");
        
     //   loan.setBranch(branch);
        
        loan_dao.save(loan);
        
        System.out.println("Loan and Branch are saved");
    }

    public void manyToOne()
	{

		Branch branch=new Branch();
		branch.setBranchCode("AG45394");
		branch.setManagerName("Mr. Manjula");
		branch.setCity("Agalawatta");
		branch.setTeleNo("034-22447698");


		StudentLoan loan1=new StudentLoan();
		loan1.setLoanType("Student");
		loan1.setLoanAmount(340000.00);
		loan1.setMonthlyInstallment(2300);
		loan1.setIssuedDate(new Date());
	//	loan1.setBranch(branch);

		StudentLoan loan2=new StudentLoan();
		loan2.setLoanAmount(1670000.00);
		loan2.setLoanType("Student");
		loan2.setLoanAmount(11600);
		loan2.setIssuedDate(new Date());
		//loan2.setBranch(branch);

		StudentLoan loan3=new StudentLoan();
		loan3.setLoanType("Student");
		loan3.setLoanAmount(770000.00);
		loan3.setMonthlyInstallment(8700);
		loan3.setIssuedDate(new Date());
		//loan3.setBranch(branch);

		loan_dao.save(loan1);
		loan_dao.save(loan2);
		loan_dao.save(loan3);

		System.out.println("Loans and Branch have been saved");

	}

	public void manyToMany()
	{
		Branch branch1=new Branch();
		branch1.setBranchCode("KL76934");
		branch1.setManagerName("Mrs. Soluchana");
		branch1.setCity("Kaluthara");
		branch1.setTeleNo("034-2276434");

		Branch branch2=new Branch();
		branch2.setBranchCode("CL");
		branch2.setManagerName("Mrs. Radha Krishnan");
		branch2.setCity("Colombo");
		branch2.setTeleNo("011-2679434");

		StudentLoan loan1=new StudentLoan();
		loan1.setLoanType("Student");
		loan1.setLoanAmount(340000.00);
		loan1.setMonthlyInstallment(2300);
		loan1.setIssuedDate(new Date());


		StudentLoan loan2=new StudentLoan();
		loan2.setLoanAmount(1670000.00);
		loan2.setLoanType("Student");
		loan2.setLoanAmount(11600);
		loan2.setIssuedDate(new Date());

		StudentLoan loan3=new StudentLoan();
		loan3.setLoanType("Student");
		loan3.setLoanAmount(770000.00);
		loan3.setMonthlyInstallment(8700);
		loan3.setIssuedDate(new Date());

		Set<Branch> branches1=new HashSet<Branch>();
		branches1.add(branch1);
		branches1.add(branch2);

		Set<Branch> branches2=new HashSet<Branch>();
		branches2.add(branch1);

		Set<Branch> branches3=new HashSet<Branch>();
		branches3.add(branch2);



		loan1.setBranches(branches1);

		loan2.setBranches(branches2);

		loan3.setBranches(branches3);

		loan_dao.save(loan1);
		loan_dao.save(loan2);
		loan_dao.save(loan3);

		System.out.println("Loans and Branches are saved");


	}
}
