package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Qualification;
import io.auroraslutions.employManagementSystem.repositories.QualificationRepository;
import io.auroraslutions.employManagementSystem.services.QualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class QualificationServiceImp implements QualificationService {

    private final QualificationRepository qualificationRepository;

    public QualificationServiceImp(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public List<Qualification> findAll() {
        return this.qualificationRepository.findAll();
    }

    @Override
    public Qualification findById(Long id) {
        Optional<Qualification> qualification = this.qualificationRepository.findById(id);

        if (!qualification.isPresent()) {
            throw new RuntimeException("Qualification Not Found. For ID value: " + id.toString());
        }

        return qualification.get();
    }

    @Override
    public Qualification findByTitle(String title) {
        Optional<Qualification> qualification = this.qualificationRepository.findByTitle(title);

        if (!qualification.isPresent()) {
            throw new RuntimeException("Qualification Not Found. For Title value: " + title);
        }

        return qualification.get();
    }

    @Override
    public void deleteById(Long id) {
        this.qualificationRepository.deleteById(id);
    }
}
