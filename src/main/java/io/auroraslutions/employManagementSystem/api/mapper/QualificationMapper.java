package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.EmployeeDTO;
import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;
import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.domain.Qualification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Mapper
public interface QualificationMapper {

    QualificationMapper INSTANCE = Mappers.getMapper(QualificationMapper.class);

    @Mappings({@Mapping(target = "employees", qualifiedByName = "employeeToEmployeeDto")})
    QualificationDTO qualificationToQualificationDto(Qualification qualification);

    Qualification qualificationDtoToQualification(QualificationDTO qualificationDTO);

    @Named("employeeToEmployeeDto")
    @Mappings({
            @Mapping(target = "skills", expression = "java(null)"),
            @Mapping(target = "qualifications", expression = "java(null)"),
            @Mapping(target = "project", expression = "java(null)"),
            @Mapping(target = "managingProjects", expression = "java(null)")})
    EmployeeDTO employeeToEmployeeDto(Employee employee);
}
