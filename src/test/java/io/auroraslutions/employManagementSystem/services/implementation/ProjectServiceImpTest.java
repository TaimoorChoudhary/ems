package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Project;
import io.auroraslutions.employManagementSystem.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Taimoor Choudhary on 9/14/18.
 */
class ProjectServiceImpTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectServiceImp projectServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        Project projectPliro = Project.builder().title("Pliro").build();
        Project projectJbilling = Project.builder().title("jBilling").build();

        when(projectRepository.findAll()).thenReturn(Arrays.asList(projectPliro, projectJbilling));

        List<Project> projectsFound = projectServiceImp.findAll();

        assertThat("All Projects not found", projectsFound.size(), is(2));
        verify(projectRepository, times(1)).findAll();
        verify(projectRepository, times(0)).findById(anyLong());
    }

    @Test
    void findById() {

        Project projectJbilling = Project.builder().id(1L).title("jBilling").build();
        Optional<Project> projectOptional = Optional.of(projectJbilling);

        when(projectRepository.findById(1L)).thenReturn(projectOptional);

        Project projectFound = projectServiceImp.findById(1L);

        assertThat("Project not found", projectFound.getId(), is(1L));
        verify(projectRepository, times(0)).findAll();
        verify(projectRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByTitle() {

        Project projectJbilling = Project.builder().id(1L).title("jBilling").build();
        Optional<Project> projectOptional = Optional.of(projectJbilling);

        when(projectRepository.findByTitle("jBilling")).thenReturn(projectOptional);

        Project projectFound = projectServiceImp.findByTitle("jBilling");

        assertThat("Project not found", projectFound.getTitle(), is("jBilling"));
        verify(projectRepository, times(1)).findByTitle(anyString());
        verify(projectRepository, times(0)).findById(anyLong());
    }

    @Test
    void deleteById() {

        Long idToDelete = Long.valueOf(3L);

        projectServiceImp.deleteById(3L);

        verify(projectRepository, times(1)).deleteById(anyLong());
    }
}