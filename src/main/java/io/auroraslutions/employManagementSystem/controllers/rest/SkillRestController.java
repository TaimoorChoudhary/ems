package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.services.SkillService;
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
@RequestMapping(SkillRestController.BASE_URL)
public class SkillRestController {

    public static final String BASE_URL = "/api/v1/skills";

    private final SkillService skillService;

    public SkillRestController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SkillDTO> getAllSkills(){

        log.debug("Requesting all available Skills");
        return skillService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public SkillDTO getSkillById(@PathVariable Long id){

        log.debug(String.format("Requesting Skill for ID: %s", id));
        return skillService.findById(id);
    }
}
