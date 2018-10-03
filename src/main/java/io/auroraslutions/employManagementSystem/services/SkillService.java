package io.auroraslutions.employManagementSystem.services;

import io.auroraslutions.employManagementSystem.api.model.SkillDTO;

import java.util.List;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
public interface SkillService {

    List<SkillDTO> findAll();

    SkillDTO findById(Long id);

    SkillDTO findByTitle(String title);

    void deleteById(Long id);
}
