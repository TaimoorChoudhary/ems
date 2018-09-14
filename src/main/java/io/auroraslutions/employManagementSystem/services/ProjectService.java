package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Project;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface ProjectService {

    List<Project> findAll();

    Optional<Project> findById(Long id);

    Optional<Project> findByTitle(String title);

    void deleteById(Long id);
}
