package io.auroraslutions.employManagementSystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@EqualsAndHashCode(exclude = {"employees"})
public class QualificationDTO {

    private Long id;

    private String title;

    @JsonProperty("completion_year")
    private Date completionYear;

    private List<EmployeeDTO> employees;

    public QualificationDTO() {
    }

    @Builder
    public QualificationDTO(Long id, String title, Date completionYear, List<EmployeeDTO> employees) {
        this.id = id;
        this.title = title;
        this.completionYear = completionYear;
        this.employees = employees;
    }
}
