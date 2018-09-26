package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Taimoor Choudhary on 9/26/18.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectRepositoryIT {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void findByTitle() {

        Optional<Project> pliro = projectRepository.findByTitle("pliro");

        assertThat("Pliro project not found", pliro.get().getTitle(), is("pliro"));
    }
}