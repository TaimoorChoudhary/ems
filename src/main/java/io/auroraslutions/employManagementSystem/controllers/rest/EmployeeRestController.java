package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.EmployeeDTO;
import io.auroraslutions.employManagementSystem.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/3/18.
 */
@Slf4j
@RestController
@RequestMapping(EmployeeRestController.BASE_URL)
@Api(description = "Employee Controller")
public class EmployeeRestController {

    public static final String BASE_URL = "/api/v1/employees";

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return all available employees.")
    public List<EmployeeDTO> getAllEmployees(){

        log.debug("Retrieving all employees");

        return employeeService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return Employee for the provided ID if available.")
    public EmployeeDTO getEmployeeById(@PathVariable Long id){

        log.debug(String.format("Retrieving employee for ID: %s", id));

        return employeeService.findById(id);
    }
}
