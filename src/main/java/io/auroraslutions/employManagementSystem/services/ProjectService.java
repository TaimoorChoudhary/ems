package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.api.model.ProjectDTO;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface ProjectService {

    List<ProjectDTO> findAll();

    ProjectDTO findById(Long id);

    ProjectDTO findByTitle(String title);

    void deleteById(Long id);
}
