package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.api.mapper.QualificationMapper;
import io.auroraslutions.employManagementSystem.api.model.QualificationDTO;
import io.auroraslutions.employManagementSystem.repositories.QualificationRepository;
import io.auroraslutions.employManagementSystem.services.QualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Service
public class QualificationServiceImp implements QualificationService {

    private final QualificationRepository qualificationRepository;
    private final QualificationMapper qualificationMapper;

    public QualificationServiceImp(QualificationRepository qualificationRepository,
                                   QualificationMapper qualificationMapper) {
        this.qualificationRepository = qualificationRepository;
        this.qualificationMapper = qualificationMapper;
    }

    @Override
    public List<QualificationDTO> findAll() {
        return this.qualificationRepository
                .findAll()
                .stream()
                .map(qualificationMapper::qualificationToQualificationDto)
                .collect(Collectors.toList());
    }

    @Override
    public QualificationDTO findById(Long id) {
        return this.qualificationRepository
                .findById(id)
                .map(qualificationMapper::qualificationToQualificationDto)
                .orElseThrow(() -> new RuntimeException("Qualification Not Found. For ID value: " + id.toString()));
    }

    @Override
    public QualificationDTO findByTitle(String title) {
        return this.qualificationRepository
                .findByTitle(title)
                .map(qualificationMapper::qualificationToQualificationDto)
                .orElseThrow(() -> new RuntimeException("Qualification Not Found. For Title value: " + title));
    }

    @Override
    public void deleteById(Long id) {
        this.qualificationRepository.deleteById(id);
    }
}
