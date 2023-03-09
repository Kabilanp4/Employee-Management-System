package com.Azentio.employeemanagementsystem.Repository;
import com.Azentio.employeemanagementsystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {}

