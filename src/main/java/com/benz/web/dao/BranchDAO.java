package com.benz.web.dao;

import com.benz.web.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDAO extends JpaRepository<Branch,String> {

    Branch findBranchByBranchCode(String b_code);
}
