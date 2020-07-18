package com.benz.web.controller;

import com.benz.web.exception.DataNotFoundException;
import com.benz.web.model.Employee;
import com.benz.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employee_service;

    @GetMapping("/all")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Employee> getEmployees()
    {
          List<Employee> employees= employee_service.getEmployees();
        System.out.println(employees.size());

          if(employees.size()!=0)
              return employees;
          else
              throw new DataNotFoundException("Data Not Available");
    }

    @PostMapping("/{eid}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Employee getEmployee(@PathVariable("eid") int eid)
    {
             Employee emp=employee_service.getEmployee(eid);

             if(emp!=null)
                 return emp;
             else
                 throw new DataNotFoundException("Data Not Available");
    }
}
