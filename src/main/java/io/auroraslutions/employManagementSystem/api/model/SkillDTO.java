package io.auroraslutions.employManagementSystem.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@EqualsAndHashCode(exclude = {"employees"})
public class SkillDTO {

    private Long id;
    private String title;
    private String description;
    private List<EmployeeDTO> employees;

    public SkillDTO() {
    }

    @Builder
    public SkillDTO(Long id, String title, String description, List<EmployeeDTO> employees) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.employees = employees;
    }
}
