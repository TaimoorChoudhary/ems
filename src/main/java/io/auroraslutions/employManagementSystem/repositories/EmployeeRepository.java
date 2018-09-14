package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);
    List<Employee> findByFirstNameAndMiddleName(String firstName, String middleName);
    List<Employee> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String LastName);

    List<Employee> findByMiddleName(String middleName);
}
