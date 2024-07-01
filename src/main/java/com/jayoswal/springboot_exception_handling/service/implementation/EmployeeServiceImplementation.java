package com.jayoswal.springboot_exception_handling.service.implementation;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;
import com.jayoswal.springboot_exception_handling.exception.ServiceException;
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

        try {
            if (id <= 0) {
                throw new ServiceException("601", "Id must be > 0");
            }
            EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new ServiceException("603", "No Employee found for id: " + id));
            return employee;
        } catch (ServiceException e) {
            throw e;  // Re-throw ServiceException else it will be overwritten in Exception catch or remove if to outside try block
        } catch (IllegalArgumentException e) {
            throw new ServiceException("602", "Id cannot be null: " + e.getMessage());
        } catch (java.util.NoSuchElementException e){
            throw new ServiceException("603", "No Employee with id: " + id+ ". " + e.getMessage());

        } catch (Exception e) {
            throw new ServiceException("500", "Something wrong in Service readEmployee(): " + e.getMessage());
        }
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
