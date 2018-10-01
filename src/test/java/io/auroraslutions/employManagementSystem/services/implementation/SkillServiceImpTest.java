package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Skill;
import io.auroraslutions.employManagementSystem.repositories.SkillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Taimoor Choudhary on 9/13/18.
 */
//@ExtendWith(MockitoJUnitRunner.class) NOTE: Not compatible as of jUnit5.0
class SkillServiceImpTest {

    @Mock
    SkillRepository skillRepository;

    @InjectMocks
    SkillServiceImp skillServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        Skill skillJava = Skill.builder().id(1L).title("Java").description("Java Developer").build();
        Skill skillSpring = Skill.builder().id(2L).title("Spring").description("Spring Developer").build();

        when(skillRepository.findAll()).thenReturn(Arrays.asList(skillJava, skillSpring));

        List<Skill> skillsFound = skillServiceImp.findAll();

        assertThat(skillsFound.size(), is(2));
        verify(skillRepository, times(0)).findById(anyLong());
        verify(skillRepository, times(1)).findAll();
    }

    @Test
    void findById() {

        Skill skill = Skill.builder().id(1L).title("Java").description("Java Developer").build();
        Optional<Skill> skillOptional = Optional.of(skill);

        when(skillRepository.findById(anyLong())).thenReturn(skillOptional);

        Skill skillFound = skillServiceImp.findById(1L);

        assertThat("Titles don't mactch", skillFound.getTitle(), is(skillOptional.get().getTitle()));
        verify(skillRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByTitle() {

        Skill skill = Skill.builder().id(1L).title("Java").description("Java Developer").build();

        when(skillRepository.findByTitle("Java")).thenReturn(Optional.of(skill));

        Skill skillFound = skillServiceImp.findByTitle("Java");

        assertThat("No skills found", not(skillFound != null));
        assertThat("Skill title don't match", skillFound.getTitle(), is(skill.getTitle()));
        verify(skillRepository, times(1)).findByTitle(anyString());
    }

    @Test
    void deleteById() {

        Long idToDelete = Long.valueOf(3L);

        skillServiceImp.deleteById(idToDelete);

        verify(skillRepository, times(1)).deleteById(anyLong());
    }
}