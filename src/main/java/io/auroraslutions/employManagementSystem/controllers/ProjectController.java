package io.auroraslutions.employManagementSystem.controllers;

import io.auroraslutions.employManagementSystem.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Taimoor Choudhary on 10/1/18.
 */
@Slf4j
@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping({"/projects", "/project"})
    public String listAll(Model model){

        log.debug("Requesting all available Projects");

        model.addAttribute("projects", projectService.findAll());

        return "project/list";
    }

    @RequestMapping("/project/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("project", projectService.findById(Long.valueOf(id)));

        return "/project/show";
    }
}
