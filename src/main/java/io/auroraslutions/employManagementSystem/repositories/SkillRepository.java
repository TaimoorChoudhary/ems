package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findByTitle(String title);
}
