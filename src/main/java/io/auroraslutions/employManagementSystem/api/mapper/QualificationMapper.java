package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;
import io.auroraslutions.employManagementSystem.domain.Qualification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Mapper
public interface QualificationMapper {

    QualificationMapper INSTANCE = Mappers.getMapper(QualificationMapper.class);

    QualificationDTO qualificationToQualificationDto(Qualification qualification);

    Qualification qualificationDtoToQualification(QualificationDTO qualificationDTO);
}
