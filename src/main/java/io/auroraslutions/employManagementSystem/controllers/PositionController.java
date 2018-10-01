package io.auroraslutions.employManagementSystem.controllers;

import io.auroraslutions.employManagementSystem.services.PositionService;
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
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping({"/positions", "/position"})
    public String listAll(Model model){

        log.debug("Requesting all available positions");

        model.addAttribute("positions", positionService.findAll());

        return "position/list";
    }

    @RequestMapping("/position/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("position", positionService.findById(Long.valueOf(id)));

        return "position/show";
    }
}
