package io.auroraslutions.employManagementSystem.api.model;

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
@EqualsAndHashCode(exclude = {"employees"})
public class SkillDTO {

    private Long id;
    private String title;
    private String description;
    private List<EmployeeDTO> employees;
}
