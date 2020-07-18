package com.benz.web.entity;

import com.benz.web.cfgs.Schema;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BRANCH",schema = Schema.LOAN)
public class Branch {

    @Id
    @Column(name="BRANCHCODE")
    private String branchCode;
    @Column(name = "MANAGERNAME",nullable = false)
    private String managerName;
    @Column(name = "CITY",nullable = false)
    private String city;
    @Column(name = "TELENO",nullable = false)
    private String teleNo;

//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "branch")
//    private StudentLoan studentLoan;

   /* @OneToMany(targetEntity = StudentLoan.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCHCODE",referencedColumnName = "BRANCHCODE")*/
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "branch")
//    private Set<StudentLoan> studentLoans;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "branches")
    private Set<StudentLoan> loans;

    public String getBranchCode() {
        return branchCode;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getCity() {
        return city;
    }

    public String getTeleNo() {
        return teleNo;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTeleNo(String teleNo) {
        this.teleNo = teleNo;
    }

    public Set<StudentLoan> getLoans() {
        return loans;
    }

    public void setLoans(Set<StudentLoan> loans) {
        this.loans = loans;
    }
}
