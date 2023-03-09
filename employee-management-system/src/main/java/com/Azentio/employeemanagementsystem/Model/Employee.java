package com.Azentio.employeemanagementsystem.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
//@Table(name = "EmployeeList")
/*
 * Pojo Class or Encapsulated Class
 */
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;

}