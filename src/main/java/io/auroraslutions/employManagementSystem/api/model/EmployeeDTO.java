package io.auroraslutions.employManagementSystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
