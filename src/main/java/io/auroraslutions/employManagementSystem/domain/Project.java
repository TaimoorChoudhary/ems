package io.auroraslutions.employManagementSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"supervisors", "employees"})
@Entity
@Table(name = "projects")
public class Project  extends BaseEntity{

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "project_supervisors", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> supervisors;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @Builder
    public Project(Long id, String title, List<Employee> supervisors) {
        super(id);
        this.title = title;
        this.supervisors = supervisors;
    }
}
