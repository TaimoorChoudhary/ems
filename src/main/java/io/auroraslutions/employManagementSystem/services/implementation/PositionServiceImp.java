package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.api.mapper.PositionMapper;
import io.auroraslutions.employManagementSystem.api.model.PositionDTO;
import io.auroraslutions.employManagementSystem.repositories.PositionRepository;
import io.auroraslutions.employManagementSystem.services.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class PositionServiceImp implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    public PositionServiceImp(PositionRepository positionRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public List<PositionDTO> findAll() {
        return this.positionRepository
                .findAll()
                .stream()
                .map(positionMapper::positionToPositionDto)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDTO findById(Long id) {
        return this.positionRepository
                .findById(id)
                .map(positionMapper::positionToPositionDto)
                .orElseThrow(() ->new RuntimeException("Position Not Found. For ID value: " + id.toString()));
    }

    @Override
    public PositionDTO findByTitle(String title) {
        return this.positionRepository
                .findByTitle(title)
                .map(positionMapper::positionToPositionDto)
                .orElseThrow(() -> new RuntimeException("Position Not Found. For Title value: " + title));
    }

    @Override
    public void deleteById(Long id) {
        this.positionRepository.deleteById(id);
    }
}
