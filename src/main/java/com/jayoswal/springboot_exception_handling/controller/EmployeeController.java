package com.jayoswal.springboot_exception_handling.controller;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;
import com.jayoswal.springboot_exception_handling.exception.ControllerException;
import com.jayoswal.springboot_exception_handling.exception.ServiceException;
import com.jayoswal.springboot_exception_handling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity created = employeeService.createEmployee(employee);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> readAllEmployee() {
        List<EmployeeEntity> allEmployees = employeeService.readAllEmployees();

        return new ResponseEntity<>(allEmployees, HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<?> readEmployee(@PathVariable int employeeId) {
        try {
            EmployeeEntity employee = employeeService.readEmployee(employeeId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (ServiceException e) {
            ControllerException controllerException = new ControllerException(e.getCode(), e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatusCode.valueOf(Integer.parseInt(e.getCode())));
        } catch (Exception e) {
            ControllerException controllerException = new ControllerException("500", e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity created = employeeService.createEmployee(employee);

        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
