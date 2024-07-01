package com.jayoswal.springboot_exception_handling.service;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public EmployeeEntity createEmployee(EmployeeEntity employee);

    public List<EmployeeEntity> readAllEmployees();

    public EmployeeEntity readEmployee(int id);

    public EmployeeEntity updateEmployee(EmployeeEntity employee);

    public void deleteEmployee(int id);
}
