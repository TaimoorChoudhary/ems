package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Qualification;
import io.auroraslutions.employManagementSystem.repositories.QualificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Taimoor Choudhary on 9/13/18.
 */
class QualificationServiceImpTest {

    @Mock
    QualificationRepository qualificationRepository;

    @InjectMocks
    QualificationServiceImp qualificationServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        Qualification qualificationBsc = Qualification.builder().title("BSc").build();
        Qualification qualificationMsc = Qualification.builder().title("MSc").build();

        when(qualificationRepository.findAll()).thenReturn(Arrays.asList(qualificationBsc, qualificationMsc));

        List<Qualification> qualificationsFound = qualificationServiceImp.findAll();

        assertThat("All Qualifications not found", qualificationsFound.size(), is(2));
        verify(qualificationRepository, times(1)).findAll();
        verify(qualificationRepository, times(0)).findById(anyLong());
    }

    @Test
    void findById() {

        Qualification qualificationBsc = Qualification.builder().id(1L).title("BSc").build();
        Optional<Qualification> qualificationOptional = Optional.of(qualificationBsc);

        when(qualificationRepository.findById(anyLong())).thenReturn(qualificationOptional);

        Qualification qualificationsFound = qualificationServiceImp.findById(1L);

        assertThat("Qualification not found",
                        qualificationsFound.getTitle(), is(qualificationBsc.getTitle()));
        verify(qualificationRepository, times(0)).findAll();
        verify(qualificationRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByTitle() {
        Qualification qualification = Qualification.builder().title("MSc").build();
        Optional<Qualification> qualificationOptional = Optional.of(qualification);

        when(qualificationRepository.findByTitle(anyString())).thenReturn(qualificationOptional);

        Qualification qualificationFound = qualificationServiceImp.findByTitle("MSc");

        assertThat("Qualification not found", qualificationFound.getTitle(), is(qualification.getTitle()));
        verify(qualificationRepository, times(1)).findByTitle(anyString());
    }

    @Test
    void deleteById() {

        Long idToDelete = Long.valueOf(3L);

        qualificationServiceImp.deleteById(idToDelete);

        verify(qualificationRepository, times(1)).deleteById(anyLong());
    }
}