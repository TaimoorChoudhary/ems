package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Employee;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    List<Employee> findByMiddleName(String name);

    void deleteById(Long id);
}
