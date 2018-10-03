package io.auroraslutions.employManagementSystem.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@EqualsAndHashCode(exclude = {"supervisors", "employees"})
public class ProjectDTO {

    private Long id;
    private String title;
    private List<EmployeeDTO> supervisors;
    private List<EmployeeDTO> employees;

    public ProjectDTO() {
    }

    @Builder
    public ProjectDTO(Long id, String title, List<EmployeeDTO> supervisors, List<EmployeeDTO> employees) {
        this.id = id;
        this.title = title;
        this.supervisors = supervisors;
        this.employees = employees;
    }
}
