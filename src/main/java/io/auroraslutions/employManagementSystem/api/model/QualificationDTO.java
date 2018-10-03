package io.auroraslutions.employManagementSystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
public class QualificationDTO {

    private Long id;

    private String title;

    @JsonProperty("completion_year")
    private Date completionYear;

    private List<EmployeeDTO> employees;
}
