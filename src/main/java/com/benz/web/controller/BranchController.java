package com.benz.web.controller;

import com.benz.web.entity.Branch;
import com.benz.web.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branch_service;

    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @PostMapping("/save")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void saveBranch(@RequestBody Branch branch) throws Exception {

        if(!branch.getBranchCode().trim().isEmpty() && !branch.getManagerName().trim().isEmpty()
        && !branch.getCity().trim().isEmpty() && !branch.getTeleNo().trim().isEmpty())
            branch_service.saveBranch(branch);
            else
                throw new NullPointerException();

    }

    @GetMapping("/all")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Branch> getBranches()
    {
           return branch_service.getBranches();
    }

    @PostMapping("/find")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Branch getBranch(@RequestBody Branch branch)
    {
        if(!branch.getBranchCode().trim().isEmpty())
            return branch_service.getBranch(branch);
        else
            throw new NullPointerException();
    }

    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @PostMapping("/oneToOne")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void oneToOne_Uni(@RequestBody Branch branch)
    {
        if(!branch.getBranchCode().trim().isEmpty() && !branch.getManagerName().trim().isEmpty()
                && !branch.getCity().trim().isEmpty() && !branch.getTeleNo().trim().isEmpty())
            branch_service.oneToOne_Uni(branch);
        else
            throw new NullPointerException();
    }

    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @PostMapping("/oneToMany")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void oneToMany(@RequestBody Branch branch)
    {

        if(!branch.getBranchCode().trim().isEmpty() && !branch.getManagerName().trim().isEmpty()
                && !branch.getCity().trim().isEmpty() && !branch.getTeleNo().trim().isEmpty())
            branch_service.oneToMany(branch);
        else
            throw new NullPointerException();
    }

    @GetMapping("/manyToMany")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void manyToMany()
    {
        branch_service.manyToMany();
    }
}
