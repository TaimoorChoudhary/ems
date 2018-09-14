package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByTitle(String title);
}
