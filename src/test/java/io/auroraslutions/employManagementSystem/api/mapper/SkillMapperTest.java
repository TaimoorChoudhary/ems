package io.auroraslutions.employManagementSystem.api.mapper;

import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.domain.Skill;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Taimoor Choudhary on 10/3/18.
 */
class SkillMapperTest {

    private static Skill _skill;
    private static SkillDTO _skillDTO;

    private static SkillMapper skillMapper;

    @BeforeAll
    static void setUp() {

        skillMapper = SkillMapper.INSTANCE;

        _skill = _skill.builder().id(1L).title("Java").description("Java Developer").build();

        Employee taimoor = Employee.builder().firstName("Muhammad").middleName("Taimoor").lastName("Choudhary")
                            .skills(Arrays.asList(_skill)).build();
        Employee sirAziz = Employee.builder().firstName("Abdul").lastName("Aziz")
                            .skills(Arrays.asList(_skill)).build();

        _skill.setEmployees(Arrays.asList(taimoor, sirAziz));


        _skillDTO = new SkillDTO();
        _skillDTO.setId(2L);
        _skillDTO.setTitle("DotNet");
        _skillDTO.setDescription("Dot Net Developer");
    }

    @Test
    void skillToSkillDto() {

        SkillDTO skillDTO = skillMapper.skillToSkillDto(_skill);

        assertThat("SKill DTO ID incorrect", skillDTO.getId(), is(1L));
        assertThat("SKill DTO Title incorrect", skillDTO.getTitle(), is("Java"));
        assertThat("SKill DTO Description incorrect", skillDTO.getDescription(), is("Java Developer"));
    }

    @Test
    void skillDtoToSkill() {
        Skill skill = skillMapper.skillDtoToSkill(_skillDTO);

        assertThat("SKill ID incorrect", skill.getId(), is(2L));
        assertThat("SKill Title incorrect", skill.getTitle(), is("DotNet"));
        assertThat("SKill Description incorrect", skill.getDescription(), is("Dot Net Developer"));
    }
}