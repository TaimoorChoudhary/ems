package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Position;
import io.auroraslutions.employManagementSystem.repositories.PositionRepository;
import io.auroraslutions.employManagementSystem.services.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class PositionServiceImp implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImp(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }

    @Override
    public Optional<Position> findById(Long id) {
        return this.positionRepository.findById(id);
    }

    @Override
    public List<Position> findByTitle(String title) {
        return this.positionRepository.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        this.positionRepository.deleteById(id);
    }
}
