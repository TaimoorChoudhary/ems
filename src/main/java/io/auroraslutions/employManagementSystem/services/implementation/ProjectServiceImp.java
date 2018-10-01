package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Project;
import io.auroraslutions.employManagementSystem.repositories.ProjectRepository;
import io.auroraslutions.employManagementSystem.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> project = this.projectRepository.findById(id);

        if (!project.isPresent()) {
            throw new RuntimeException("Project Not Found. For ID value: " + id.toString());
        }

        return project.get();
    }

    @Override
    public Project findByTitle(String title) {
        Optional<Project> project = this.projectRepository.findByTitle(title);

        if (!project.isPresent()) {
            throw new RuntimeException("Project Not Found. For Title value: " + title);
        }

        return project.get();
    }

    @Override
    public void deleteById(Long id) {
        this.projectRepository.deleteById(id);
    }

}
