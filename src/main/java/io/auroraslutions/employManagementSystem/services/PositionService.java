package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.api.model.PositionDTO;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface PositionService {

    List<PositionDTO> findAll();

    PositionDTO findById(Long id);

    PositionDTO findByTitle(String title);

    void deleteById(Long id);
}
