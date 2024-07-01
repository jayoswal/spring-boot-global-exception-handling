package com.jayoswal.springboot_exception_handling.repository;

import com.jayoswal.springboot_exception_handling.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
