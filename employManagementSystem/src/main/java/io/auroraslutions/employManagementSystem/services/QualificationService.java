package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Qualification;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface QualificationService {

    List<Qualification> findAll();

    Optional<Qualification> findById(Long id);

    Optional<Qualification> findByTitle(String title);

    void deleteById(Long id);
}
