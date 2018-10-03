package io.auroraslutions.employManagementSystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@EqualsAndHashCode(exclude = {"supervisors", "qualifications"})
public class EmployeeDTO {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    private PositionDTO position;

    private List<SkillDTO> skills;

    private List<QualificationDTO> qualifications;

    private ProjectDTO project;

    @JsonProperty("managing_projects")
    private List<ProjectDTO> managingProjects;

    public EmployeeDTO() {
    }

    @Builder
    public EmployeeDTO(Long id, String firstName, String middleName, String lastName, PositionDTO position,
                       List<SkillDTO> skills, List<QualificationDTO> qualifications, ProjectDTO project,
                       List<ProjectDTO> managingProjects) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.skills = skills;
        this.qualifications = qualifications;
        this.project = project;
        this.managingProjects = managingProjects;
    }
}
