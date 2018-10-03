package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.api.mapper.ProjectMapper;
import io.auroraslutions.employManagementSystem.api.model.ProjectDTO;
import io.auroraslutions.employManagementSystem.repositories.ProjectRepository;
import io.auroraslutions.employManagementSystem.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImp(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> findAll() {
        return this.projectRepository
                .findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findById(Long id) {
        return this.projectRepository
                .findById(id)
                .map(projectMapper::projectToProjectDto)
                .orElseThrow(() -> new RuntimeException("Project Not Found. For ID value: " + id.toString()));
    }

    @Override
    public ProjectDTO findByTitle(String title) {
        return this.projectRepository
                .findByTitle(title)
                .map(projectMapper::projectToProjectDto)
                .orElseThrow(() -> new RuntimeException("Project Not Found. For Title value: " + title));
    }

    @Override
    public void deleteById(Long id) {
        this.projectRepository.deleteById(id);
    }

}
