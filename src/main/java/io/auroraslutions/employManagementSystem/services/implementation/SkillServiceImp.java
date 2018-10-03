package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.api.mapper.SkillMapper;
import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.repositories.SkillRepository;
import io.auroraslutions.employManagementSystem.services.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class SkillServiceImp implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillServiceImp(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<SkillDTO> findAll() {
        return this.skillRepository
                .findAll()
                .stream()
                .map(skillMapper::skillToSkillDto)
                .collect(Collectors.toList());
    }

    @Override
    public SkillDTO findById(Long id) {
        return this.skillRepository
                .findById(id)
                .map(skillMapper::skillToSkillDto)
                .orElseThrow(() -> new RuntimeException("Skill Not Found. For ID value: " + id.toString()));
    }

    @Override
    public SkillDTO findByTitle(String title) {
        return this.skillRepository
                .findByTitle(title)
                .map(skillMapper::skillToSkillDto)
                .orElseThrow(() -> new RuntimeException("Skill Not Found. For ID value: " + title));
    }

    @Override
    public void deleteById(Long id) {
        this.skillRepository.deleteById(id);
    }
}
