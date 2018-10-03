package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.PositionDTO;
import io.auroraslutions.employManagementSystem.domain.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Taimoor Choudhary on 10/2/18.
 */
@Mapper
public interface PositionMapper {

    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    PositionDTO positionToPositionDto(Position position);

    Position positionDtoToPosition(PositionDTO positionDTO);
}
