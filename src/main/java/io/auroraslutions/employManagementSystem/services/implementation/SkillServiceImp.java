package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Skill;
import io.auroraslutions.employManagementSystem.repositories.SkillRepository;
import io.auroraslutions.employManagementSystem.services.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class SkillServiceImp implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImp(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> findAll() {
        return this.skillRepository.findAll();
    }

    @Override
    public Skill findById(Long id) {
        Optional<Skill> skill = this.skillRepository.findById(id);

        if (!skill.isPresent()) {
            throw new RuntimeException("Skill Not Found. For ID value: " + id.toString());
        }

        return skill.get();
    }

    @Override
    public Skill findByTitle(String title) {
        Optional<Skill> skill = this.skillRepository.findByTitle(title);

        if (!skill.isPresent()) {
            throw new RuntimeException("Skill Not Found. For ID value: " + title);
        }

        return skill.get();
    }

    @Override
    public void deleteById(Long id) {
        this.skillRepository.deleteById(id);
    }
}
