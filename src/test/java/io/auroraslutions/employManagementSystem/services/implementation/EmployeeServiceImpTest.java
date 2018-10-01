package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Taimoor Choudhary on 9/14/18.
 */
class EmployeeServiceImpTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImp employeeServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findEmployees() {

        Employee employeeTaimoor = Employee.builder().middleName("Taimoor").lastName("Choudhary").build();
        Employee employeeAziz = Employee.builder().firstName("Abdul").lastName("Aziz").build();

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employeeAziz, employeeTaimoor));

        List<Employee> employeesFound = employeeServiceImp.findAll();

        assertThat("All Employees not found", employeesFound.size(), is(2));
        verify(employeeRepository, times(1)).findAll();
        verify(employeeRepository, times(0)).findById(anyLong());
    }

    @Test
    void findById() {

        Employee employeeTaimoor = Employee.builder().id(1L).middleName("Taimoor").lastName("Choudhary").build();
        Optional<Employee> optionalEmployee = Optional.of(employeeTaimoor);

        when(employeeRepository.findById(1L)).thenReturn(optionalEmployee);

        Employee employeeFound = employeeServiceImp.findById(1L);

        assertThat("Employee not found", employeeFound.getId(), is(1L));
        verify(employeeRepository, times(0)).findAll();
        verify(employeeRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByMiddleName() {

        Employee employeeTaimoor = Employee.builder().id(1L).middleName("Taimoor").lastName("Choudhary").build();

        when(employeeRepository.findByMiddleName("Taimoor")).thenReturn(Arrays.asList(employeeTaimoor));

        List<Employee> employeeFound = employeeServiceImp.findByMiddleName("Taimoor");

        assertThat("Employee list size mismatch", employeeFound.size(), is(1));
        assertThat("Employee not found", employeeFound.get(0).getMiddleName(), is(employeeTaimoor.getMiddleName()));
        verify(employeeRepository, times(1)).findByMiddleName(anyString());
        verify(employeeRepository, times(0)).findById(anyLong());
    }

    @Test
    void deleteById() {

        Long idToDelete = 3l;

        employeeServiceImp.deleteById(idToDelete);

        verify(employeeRepository, times(1)).deleteById(anyLong());
    }
}