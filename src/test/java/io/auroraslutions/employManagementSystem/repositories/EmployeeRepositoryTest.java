package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;

/**
 * Created by Taimoor Choudhary on 9/26/18.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findByFirstName() {

        List<Employee> firstName = employeeRepository.findByFirstName("Abdul");

        assertThat("No employee found for first name", firstName.size(), is(1));
        assertThat("First Name Abdul Not found", firstName.get(0).getFirstName(), is("Abdul"));
    }

    @Test
    void findByFirstNameAndMiddleName() {

        List<Employee> firstAndMiddleName = employeeRepository.findByFirstNameAndMiddleName("Abdul", null);

        assertThat("No employee found for first and middle name", firstAndMiddleName.size(), is(1));
        assertThat("First Name Abdul Not found", firstAndMiddleName.get(0).getFirstName(), is("Abdul"));
        assertThat("Empty Middle Name Not found", firstAndMiddleName.get(0).getMiddleName(), isEmptyOrNullString());
    }

    @Test
    void findByFirstNameAndMiddleNameAndLastName() {

        List<Employee> firstMiddleLastName = employeeRepository.
                findByFirstNameAndMiddleNameAndLastName("Abdul", null, "Aziz");

        assertThat("No employee found for first, middle and last name", firstMiddleLastName.size(), is(1));
        assertThat("First Name Abdul Not found", firstMiddleLastName.get(0).getFirstName(), is("Abdul"));
        assertThat("Empty Middle Name Not found", firstMiddleLastName.get(0).getMiddleName(), isEmptyOrNullString());
        assertThat("Last Name Aziz Not found", firstMiddleLastName.get(0).getLastName(), is("Aziz"));
    }

    @Test
    void findByMiddleName() {

        List<Employee> middleName = employeeRepository.findByMiddleName("Taimoor");

        assertThat("No employee found for middle name", middleName.size(), is(1));
        assertThat("Middle Name Taimoor Not found", middleName.get(0).getMiddleName(), is("Taimoor"));
    }
}