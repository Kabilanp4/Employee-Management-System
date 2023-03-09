package com.Azentio.employeemanagementsystem.Controller;
import java.util.List;

import com.Azentio.employeemanagementsystem.Model.Employee;
import com.Azentio.employeemanagementsystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    /*
     * Function to add a Student
     */
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return service.createEmployee(employee);
    }
    /*
     * Function to add a List of Student
     */

    /*
     * Function to get a Student by Id
     */
    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return service.getEmployee(id);
    }
    /*
     * Function to get all Students
     */
    @GetMapping("/getall")
    public List<Employee> getAll()
    {
        return service.getAllEmployee();
    }
    /*
     * Function to delete a Student by Id
     */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return service.deleteEmployee(id);
    }
    /*
     * Function to update a Student
     */
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee)
    {
        Employee result = service.updateEmployee(employee);
        if(result.getName() == null) return "ID not present";
        else return "Updated Successfully";
    }

}