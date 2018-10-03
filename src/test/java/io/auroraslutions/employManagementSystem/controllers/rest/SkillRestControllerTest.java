package io.auroraslutions.employManagementSystem.controllers.rest;

import io.auroraslutions.employManagementSystem.api.model.SkillDTO;
import io.auroraslutions.employManagementSystem.services.SkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Taimoor Choudhary on 10/3/18.
 */
class SkillRestControllerTest {

    @Mock
    SkillService skillService;

    @InjectMocks
    SkillRestController restController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    void getAllSkills() throws Exception {

        SkillDTO skillJava = SkillDTO.builder().id(1L).title("Java").description("Java Developer").build();
        SkillDTO skillSpring = SkillDTO.builder().id(2L).title("Spring").description("Spring Developer").build();

        when(skillService.findAll()).thenReturn(Arrays.asList(skillJava, skillSpring));

        mockMvc.perform(get(SkillRestController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getSkillById() throws Exception {

        SkillDTO skillSpring = SkillDTO.builder().id(2L).title("Spring").description("Spring Developer").build();

        when(skillService.findById(anyLong())).thenReturn(skillSpring);

        mockMvc.perform(get(SkillRestController.BASE_URL + "/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Spring")));
    }
}