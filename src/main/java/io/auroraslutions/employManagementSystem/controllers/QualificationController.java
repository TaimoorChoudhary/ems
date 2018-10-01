package io.auroraslutions.employManagementSystem.controllers;

import io.auroraslutions.employManagementSystem.services.QualificationService;
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
public class QualificationController {

    private final QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @RequestMapping({"/qualifications" ,"/qualification"})
    public String listAll(Model model){

        log.debug("Requesting all available Qualifications");

        model.addAttribute("qualifications", qualificationService.findAll());

        return "qualification/list";
    }

    @RequestMapping("qualification/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("qualification", qualificationService.findById(Long.valueOf(id)));

        return "qualification/show";
    }
}
