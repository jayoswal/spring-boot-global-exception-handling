package com.jayoswal.springboot_exception_handling.service.implementation;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;
import com.jayoswal.springboot_exception_handling.repository.EmployeeRepository;
import com.jayoswal.springboot_exception_handling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeEntity employee) {

        EmployeeEntity created = employeeRepository.save(employee);

        return created;
    }

    public List<EmployeeEntity> readAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity readEmployee(int id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        // if not found throws -> java.util.NoSuchElementException
        return employee;
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        EmployeeEntity created = employeeRepository.save(employee);

        return created;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
