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
    public Position findById(Long id) {
        Optional<Position> position = this.positionRepository.findById(id);

        if (!position.isPresent()) {
            throw new RuntimeException("Position Not Found. For ID value: " + id.toString());
        }

        return position.get();
    }

    @Override
    public Position findByTitle(String title) {
        Optional<Position> position = this.positionRepository.findByTitle(title);

        if (!position.isPresent()) {
            throw new RuntimeException("Position Not Found. For Title value: " + title);
        }

        return position.get();
    }

    @Override
    public void deleteById(Long id) {
        this.positionRepository.deleteById(id);
    }
}
