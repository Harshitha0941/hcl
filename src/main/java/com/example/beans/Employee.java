package com.example.beans;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Component
public class Employee {
	private int id;
	 private String name;
	 private String department;
	 private float salary;
}
//Employee