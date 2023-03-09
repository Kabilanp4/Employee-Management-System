package com.Azentio.employeemanagementsystem.Service;

import java.util.List;
import java.util.Optional;

import com.Azentio.employeemanagementsystem.Model.Employee;
import com.Azentio.employeemanagementsystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeesRepository;
    /*
     * Service function to Create a Student
     */
    public Employee createEmployee(Employee employee)
    {
        return employeesRepository.save(employee);
    }
    /*
     * Service function to get a Student
     */
    public Employee getEmployee(int id)
    {
        return employeesRepository.findById(id).orElse(null);
    }
    /*
     * Service function to get all Student
     */
    public List<Employee> getAllEmployee()
    {
        return employeesRepository.findAll();
    }
    /*
     * Service function to Create a List of Students
     */
    public List<Employee> createEmployeeList(List<Employee> employees)
    {
        return employeesRepository.saveAll(employees);
    }
    /*
     * Service function to Delete a Student by  Id
     */
    public String deleteEmployee(int id)
    {
        employeesRepository.deleteById(id);
        return "Employee Deleted Successefully";
    }
    /*
     * Service function to Update a Student by Request Body
     */
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee oldData = null;
        Optional<Employee> optional = employeesRepository.findById(employee.getId());
        if (optional.isPresent()) {
            oldData = optional.get();
            oldData.setId(employee.getId());
            oldData.setName(employee.getName());
            oldData.setSalary(employee.getSalary());
            return employeesRepository.save(oldData);

        }
        else
        {
            return new Employee();
        }
    }
}