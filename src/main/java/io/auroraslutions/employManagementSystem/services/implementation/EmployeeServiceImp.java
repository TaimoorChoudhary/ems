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
    public Employee findById(Long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        if (!employee.isPresent()) {
            throw new RuntimeException("Employee Not Found. For ID value: " + id.toString());
        }

        return employee.get();
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
