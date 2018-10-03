package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.ProjectDTO;
import io.auroraslutions.employManagementSystem.services.ProjectService;
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
@RequestMapping(ProjectRestController.BASE_URL)
public class ProjectRestController {

    public static final String BASE_URL = "/api/v1/projects";

    private final ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectDTO> getAllProjects(){

        log.debug("Requesting all available Projects");
        return projectService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO getProjectById(@PathVariable Long id){

        log.debug(String.format("Requesting Project for ID: %s", id));
        return projectService.findById(id);
    }
}
