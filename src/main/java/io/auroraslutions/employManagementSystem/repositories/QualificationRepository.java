package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

    Optional<Qualification> findByTitle(String title);
}
