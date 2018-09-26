package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Position;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface PositionService {

    List<Position> findAll();

    Optional<Position> findById(Long id);

    Optional<Position> findByTitle(String title);

    void deleteById(Long id);
}
