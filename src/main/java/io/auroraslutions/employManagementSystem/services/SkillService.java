package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Skill;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface SkillService {

    List<Skill> findAll();

    Optional<Skill> findById(Long id);

    Optional<Skill> findByTitle(String title);

    void deleteById(Long id);
}
