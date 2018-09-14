package io.auroraslutions.employManagementSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Taimoor Choudhary on 9/11/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
public class Position extends BaseEntity {

    @Column(name = "type")
    private String title;

    @Column(name = "description")
    private String description;

    @Builder
    public Position(Long id, String title, String description) {
        super(id);
        this.title = title;
        this.description = description;
    }
}
