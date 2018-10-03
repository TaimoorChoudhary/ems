package io.auroraslutions.employManagementSystem.api.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Data
public class PositionDTO {

    private Long id;
    private String title;
    private String description;

    public PositionDTO() {
    }

    @Builder
    public PositionDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
