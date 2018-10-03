package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.api.model.EmployeeDTO;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Long id);

    List<EmployeeDTO> findByMiddleName(String name);

    void deleteById(Long id);
}
