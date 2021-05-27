package com.example.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;
import com.example.exception.IdException;
import com.example.service.EmployeeServices;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	@Autowired
    private EmployeeServices ed;
    @GetMapping("/hello")
    public ArrayList<Employee> sayHello() {
        ArrayList<Employee> ls=new ArrayList<Employee>();
        ls=ed.displayEmployees();
        return ls;
    }
    @PostMapping("/emp")
    public Employee saveUser(@RequestBody Employee employee) throws IdException {
       Employee employee1 = ed.addEmployee(employee);
       return employee1;
    }
    @DeleteMapping("/delete/{id}")
    public boolean delEmp(@PathVariable int id){
		try {
			ed.deleteEmployee(id);
		} catch (IdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return true;
    }
    @PutMapping("/update/{id}")
    public boolean updateEmp(@PathVariable int id,@RequestBody Employee employee) throws IdException{
		ed.updateEmployee(employee);
       return true;
    }
    @GetMapping("/getemp/{id}")
    public ArrayList<Employee> getEmpOnId(@PathVariable int id) throws IdException{
       ArrayList<Employee> empList=ed.searchEmployee(id);
       return empList;
    }

}
