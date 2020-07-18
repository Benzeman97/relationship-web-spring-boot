package com.benz.web.services;

import com.benz.web.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees()
    {
        return Arrays.asList(
                new Employee(101,"Kelly Brook"),
                new Employee(103,"Julia Ann"),
                new Employee(105,"Nafaz Benzema")
        );
    }

    public Employee getEmployee(int eid)
    {
        List<Employee> employees=Arrays.asList(
                new Employee(101,"Kelly Brook"),
                new Employee(103,"Julia Ann"),
                new Employee(105,"Nafaz Benzema")
        );

        for (Employee e:employees)
            if(e.getEid()==eid)
                return e;

            return null;
    }
}
