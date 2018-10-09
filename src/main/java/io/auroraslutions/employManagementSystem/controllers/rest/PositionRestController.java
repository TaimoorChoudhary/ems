package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.PositionDTO;
import io.auroraslutions.employManagementSystem.services.PositionService;
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
@RequestMapping(PositionRestController.BASE_URL)
@Api(description = "Organization Positions Controller")
public class PositionRestController {

    public static final String BASE_URL = "/api/v1/positions";

    private final PositionService positionService;

    public PositionRestController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return all available Positions in the Organization.")
    public List<PositionDTO> getAllPosition(){

        log.debug("Requesting all available positions");
        return positionService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return Organization Position for the provided ID if available.")
    public PositionDTO getPositionById(@PathVariable Long id){

        log.debug(String.format("Requesting Position for ID: %s", id));
        return positionService.findById(id);
    }
}
