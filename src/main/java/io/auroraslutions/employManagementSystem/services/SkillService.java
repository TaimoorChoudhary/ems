package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.domain.Skill;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface SkillService {

    List<Skill> findAll();

    Skill findById(Long id);

    Skill findByTitle(String title);

    void deleteById(Long id);
}
