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
import java.util.Date;
import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@Entity
@Table(name = "qualifications")
public class Qualification extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "completion_year")
    private Date completionYear;

    @ManyToMany(mappedBy = "qualifications")
    private List<Employee> employees;


    @Builder
    public Qualification(Long id, String title, Date completionYear, List<Employee> employees) {
        super(id);
        this.title = title;
        this.completionYear = completionYear;
        this.employees = employees;
    }
}
