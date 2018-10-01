package io.auroraslutions.employManagementSystem.controllers;

import io.auroraslutions.employManagementSystem.services.SkillService;
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
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @RequestMapping({"/skills", "/skill"})
    public String listAll(Model model){

        log.debug("Requesting all available Skills");

        model.addAttribute("skills", skillService.findAll());

        return "skill/list";
    }

    @RequestMapping("/skill/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("skill", skillService.findById(Long.valueOf(id)));

        return "skill/show";
    }
}
