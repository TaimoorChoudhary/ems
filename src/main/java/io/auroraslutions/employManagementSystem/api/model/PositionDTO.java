package io.auroraslutions.employManagementSystem.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {

    private Long id;

    private String title;

    private String description;
}
