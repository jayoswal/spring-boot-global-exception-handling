package com.jayoswal.springboot_exception_handling.controller;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;
import com.jayoswal.springboot_exception_handling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("new")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity created = employeeService.createEmployee(employee);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeEntity>> readAllEmployee() {
        List<EmployeeEntity> allEmployees = employeeService.readAllEmployees();

        return new ResponseEntity<>(allEmployees, HttpStatus.CREATED);
    }

    @GetMapping("employee/{employeeId}")
    public ResponseEntity<EmployeeEntity> readEmployee(@PathVariable int employeeId) {
        EmployeeEntity employee = employeeService.readEmployee(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity created = employeeService.createEmployee(employee);

        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @DeleteMapping("employee/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
