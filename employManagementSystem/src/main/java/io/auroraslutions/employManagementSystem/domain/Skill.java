package io.auroraslutions.employManagementSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/11/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@Entity
@Table(name = "skills")
public class Skill extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private List<Employee> employees;

    @Builder
    public Skill(Long id, String title, String description, List<Employee> employees) {
        super(id);
        this.title = title;
        this.description = description;
        this.employees = employees;
    }
}
