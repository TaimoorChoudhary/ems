package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.repositories.EmployeeRepository;
import io.auroraslutions.employManagementSystem.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByMiddleName(String name) {
        return this.employeeRepository.findByMiddleName(name);
    }

    @Override
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
