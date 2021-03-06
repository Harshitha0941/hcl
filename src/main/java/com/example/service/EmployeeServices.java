package com.example.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Employee;
import com.example.dao.EmployeeDAO;
import com.example.exception.IdException;


@Service
public class EmployeeServices {
	@Autowired
    private EmployeeDAO ed;
	public  ArrayList<Employee> displayEmployees() {
		return ed.displayEmployees();
	}
	public  Employee addEmployee(Employee employee) throws IdException {
		return ed.addEmployee(employee);
	}
	public  void deleteEmployee(int id) throws IdException {
		ed.deleteEmployee(id);
	}
	public  void updateEmployee(Employee employee) throws IdException{
		ed.updateEmployee(employee);
	}
	public  ArrayList<Employee> searchEmployee(int id3) throws IdException{
		return ed.searchEmployee(id3);
}
}
