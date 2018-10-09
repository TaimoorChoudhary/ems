package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;
import io.auroraslutions.employManagementSystem.services.QualificationService;
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
@RequestMapping(QualificationRestController.BASE_URL)
@Api(description = "Employees Qualifications Controller")
public class QualificationRestController {

    public static final String BASE_URL = "/api/v1/qualifications";

    private final QualificationService qualificationService;

    public QualificationRestController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return all available Organization Employees Qualifications.")
    public List<QualificationDTO> getAllQualifications(){

        log.debug("Requesting all availale qualifications");
        return qualificationService.findAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Will return Qualification for the provided ID if available.")
    public QualificationDTO getQualificationById(@PathVariable Long id){

        log.debug(String.format("Requesting Qualification for ID: %s", id));
        return qualificationService.findById(id);
    }
}
