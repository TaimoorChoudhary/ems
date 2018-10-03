package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.EmployeeDTO;
import io.auroraslutions.employManagementSystem.api.model.ProjectDTO;
import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;
import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.domain.Project;
import io.auroraslutions.employManagementSystem.domain.Qualification;
import io.auroraslutions.employManagementSystem.domain.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(target = "skills", qualifiedByName = "skillToSkillDto"),
            @Mapping(target = "qualifications", qualifiedByName = "skillToSkillDto"),
            @Mapping(target = "project", qualifiedByName = "projectToProjectDto"),
            @Mapping(target = "managingProjects", qualifiedByName = "projectToProjectDto")})
    EmployeeDTO employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);

    @Named("skillToSkillDto")
    @Mappings({@Mapping(target = "employees", expression = "java(null)")})
    SkillDTO skillToSkillDto(Skill skill);

    @Named("qualificationToQualificationDto")
    @Mappings({@Mapping(target = "employees", expression = "java(null)")})
    QualificationDTO qualificationToQualificationDto(Qualification qualification);

    @Named("projectToProjectDto")
    @Mappings({
            @Mapping(target = "employees", expression = "java(null)"),
            @Mapping(target = "supervisors", expression = "java(null)")})
    ProjectDTO projectToProjectDto(Project project);
}
