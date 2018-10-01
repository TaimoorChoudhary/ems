package io.auroraslutions.employManagementSystem.controllers;

import io.auroraslutions.employManagementSystem.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taimoor Choudhary on 9/27/18.
 */
@Slf4j
@Controller
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping({"", "/", "/index", "/employees", "/employee"})
    public String listAll(Model model){

        log.debug("Retrieving all employees");

        model.addAttribute("employees", employeeService.findAll());

        return "index";
    }

    @RequestMapping("/employee/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("employee", employeeService.findById(new Long(id)));

        return "employee/show";
    }
}
