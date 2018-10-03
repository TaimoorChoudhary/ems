package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface QualificationService {

    List<QualificationDTO> findAll();

    QualificationDTO findById(Long id);

    QualificationDTO findByTitle(String title);

    void deleteById(Long id);
}
