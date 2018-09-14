package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    List<Employee> findByMiddleName(String name);

    void deleteById(Long id);
}
