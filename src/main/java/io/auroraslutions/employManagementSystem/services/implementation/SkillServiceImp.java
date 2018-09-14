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
    public Optional<Skill> findById(Long id) {
        return this.skillRepository.findById(id);
    }

    @Override
    public List<Skill> findByTitle(String title) {
        return this.skillRepository.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        this.skillRepository.deleteById(id);
    }
}
