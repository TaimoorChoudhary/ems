package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.EmployeeDTO;
import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.domain.Employee;
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
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mappings({@Mapping(target = "employees", qualifiedByName = "employeeToEmployeeDto")})
    SkillDTO skillToSkillDto(Skill skill);

    Skill skillDtoToSkill(SkillDTO skillDTO);

    @Named("employeeToEmployeeDto")
    @Mappings({
            @Mapping(target = "skills", expression = "java(null)"),
            @Mapping(target = "qualifications", expression = "java(null)"),
            @Mapping(target = "project", expression = "java(null)"),
            @Mapping(target = "managingProjects", expression = "java(null)")})
    EmployeeDTO employeeToEmployeeDto(Employee employee);
}
