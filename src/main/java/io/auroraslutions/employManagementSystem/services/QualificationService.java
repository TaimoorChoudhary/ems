package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Qualification;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface QualificationService {

    List<Qualification> findAll();

    Qualification findById(Long id);

    Qualification findByTitle(String title);

    void deleteById(Long id);
}
