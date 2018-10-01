package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Position;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface PositionService {

    List<Position> findAll();

    Position findById(Long id);

    Position findByTitle(String title);

    void deleteById(Long id);
}
