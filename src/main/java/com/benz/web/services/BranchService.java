package com.benz.web.services;

import com.benz.web.dao.BranchDAO;
import com.benz.web.entity.Branch;
import com.benz.web.entity.StudentLoan;
import com.benz.web.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BranchService {

    @Autowired
    BranchDAO branch_dao;

    public void saveBranch(Branch branch) throws Exception
    {
        branch_dao.save(branch);
        System.out.println("Branch has been saved");
    }

    public List<Branch> getBranches()
    {
        List<Branch> branches=branch_dao.findAll();

        if(branches.size()!=0)
            return branches;
        else
            throw new DataNotFoundException("Data Not Available");

    }

    public Branch getBranch(Branch branch)
    {
           Branch n_branch=  branch_dao.findBranchByBranchCode(branch.getBranchCode());

           if(n_branch!=null)
               return n_branch;
           else
               throw new DataNotFoundException("Data Not Available");
    }

    public void oneToOne_Uni(Branch branch)
    {

    	
        StudentLoan loan=new StudentLoan();
        
        loan.setLoanNumber(543323);
        loan.setLoanType("Student");
        loan.setLoanAmount(2300000.00);
        loan.setMonthlyInstallment(22300.00);
        loan.setIssuedDate(new Date());

       //branch.setStudentLoan(loan);
        
        

        branch_dao.save(branch);

        System.out.println("Branch and Loan are saved");
    }

    public void oneToMany(Branch branch)
    {
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

        Set<StudentLoan> loans= new HashSet<StudentLoan>();

        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);

       // branch.setStudentLoans(loans);

               branch_dao.save(branch);

        System.out.println("Branch and Loans are saved");
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

        Set<StudentLoan> s_loans1=new HashSet<StudentLoan>();

        s_loans1.add(loan1);
        s_loans1.add(loan2);
        s_loans1.add(loan3);

        branch1.setLoans(s_loans1);

        Set<StudentLoan> s_loans2=new HashSet<StudentLoan>();

        s_loans1.add(loan2);
        s_loans1.add(loan3);

        branch2.setLoans(s_loans2);

        branch_dao.save(branch1);
        branch_dao.save(branch2);

        System.out.println("Branches and Loans are saved");
    }
}
