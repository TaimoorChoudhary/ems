package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Project;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface ProjectService {

    List<Project> findAll();

    Project findById(Long id);

    Project findByTitle(String title);

    void deleteById(Long id);
}
