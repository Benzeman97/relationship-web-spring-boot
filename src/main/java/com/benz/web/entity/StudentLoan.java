package com.benz.web.entity;

import com.benz.web.cfgs.Schema;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "STUDENTLOAN",schema = Schema.LOAN)
public class StudentLoan {

	@Id
	@Column(name = "LOANNUMBER")
    @SequenceGenerator(name = "Loan_Num_Gen",sequenceName = "LOAN_NUM_SEQ",initialValue = 67001,allocationSize = 2)
    @GeneratedValue(generator = "Loan_Num_Gen",strategy = GenerationType.SEQUENCE)
    private int loanNumber;
    @Column(name = "LOANTYPE",nullable = false)
    private String loanType;
    @Column(name = "LOANAMOUNT",nullable = false)
    private double loanAmount;
    @Column(name = "MONTHLYINSTALLMENT",nullable = false)
    private double monthlyInstallment;
    @Column(name = "ISSUEDDATE",nullable = false)
    private Date issuedDate;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "BRANCHCODE")
//    private Branch branch;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "BRANCHCODE")
//	private Branch branch;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BRANCHCODE")
	private Set<Branch> branches;

	public int getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getMonthlyInstallment() {
		return monthlyInstallment;
	}
	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}
}
