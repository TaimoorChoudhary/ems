package io.auroraslutions.employManagementSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/10/18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="employees")
public class Employee extends User {

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToMany
    @JoinTable(name = "employee_skills", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    @ManyToMany
    @JoinTable(name = "employee_qualifications", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private List<Qualification> qualifications;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToMany(mappedBy = "supervisors")
    private List<Project> managingProjects;

    @Builder
    public Employee(Long id, String firstName, String middleName, String lastName, Position position, List<Skill> skills,
                    List<Qualification> qualifications, Project project) {
        super(id, firstName, middleName, lastName);
        this.position = position;
        this.skills = skills;
        this.qualifications = qualifications;
        this.project = project;
    }
}
