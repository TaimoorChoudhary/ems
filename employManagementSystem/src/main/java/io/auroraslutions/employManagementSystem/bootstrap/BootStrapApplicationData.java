package io.auroraslutions.employManagementSystem.bootstrap;

import io.auroraslutions.employManagementSystem.domain.Employee;
import io.auroraslutions.employManagementSystem.domain.Position;
import io.auroraslutions.employManagementSystem.domain.Project;
import io.auroraslutions.employManagementSystem.domain.Qualification;
import io.auroraslutions.employManagementSystem.domain.Skill;
import io.auroraslutions.employManagementSystem.repositories.EmployeeRepository;
import io.auroraslutions.employManagementSystem.repositories.ProjectRepository;
import io.auroraslutions.employManagementSystem.repositories.QualificationRepository;
import io.auroraslutions.employManagementSystem.repositories.PositionRepository;
import io.auroraslutions.employManagementSystem.repositories.SkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Taimoor Choudhary on 9/12/18.
 */
@Slf4j
@Component
public class BootStrapApplicationData implements ApplicationListener<ContextRefreshedEvent> {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final QualificationRepository qualificationRepository;
    private final PositionRepository positionRepository;
    private final SkillRepository skillRepository;

    private Position teamLeadPosition;
    private Position ceoPosition;
    private Qualification bachelorsQualification;
    private Project jbillingProject;
    private Project pliroProject;
    private Skill javaSkill;
    private Skill springSkill;
    private Skill dotNetSkill;

    public BootStrapApplicationData(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
                         QualificationRepository qualificationRepository, PositionRepository positionRepository,
                                    SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.qualificationRepository = qualificationRepository;
        this.positionRepository = positionRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.debug("Loading Bootstrap Data - Starting");

        loadSkills();
        loadQualifications();
        loadPosition();
        loadProjects();
        loadEmployees();

        log.debug("Loading Bootstrap Data - Finished");
    }

    private void loadSkills(){

        javaSkill = Skill.builder().title("Java").description("Java developer").build();
        springSkill = Skill.builder().title("Spring").description("Spring framework developer").build();
        dotNetSkill = Skill.builder().title("DotNet").description(".Net developer").build();

        skillRepository.saveAll(Arrays.asList(javaSkill, springSkill, dotNetSkill));
    }

    private void loadPosition(){

        Position juniorDeveloperPosition = Position.builder().title("Jr. Developer")
                .description("Junior Developer").build();

        Position developerPosition = Position.builder().title("Developer")
                .description("Developer").build();

        teamLeadPosition = Position.builder().title("TL")
                .description("Team Lead").build();

        Position managerPosition = Position.builder().title("Manager")
                .description("Manager").build();

        ceoPosition = Position.builder().title("CEO")
                .description("Boss").build();

        positionRepository.saveAll(Arrays.asList(juniorDeveloperPosition, developerPosition,
                teamLeadPosition, managerPosition, ceoPosition));
    }

    private void loadQualifications(){

        bachelorsQualification = Qualification.builder().title("Bachelors").build();
        Qualification mastersQualification = Qualification.builder().title("Masters").build();

        qualificationRepository.saveAll(Arrays.asList(bachelorsQualification, mastersQualification));

    }

    private void loadProjects(){

        jbillingProject = Project.builder().title("jBilling").build();
        pliroProject = Project.builder().title("pliro").build();

        projectRepository.saveAll(Arrays.asList(jbillingProject, pliroProject));
    }

    private void loadEmployees(){

        Employee taimoor = Employee.builder().firstName("Muhammad").middleName("Taimoor").lastName("Choudhary")
                                    .position(teamLeadPosition).project(jbillingProject)
                                    .qualifications(Arrays.asList(bachelorsQualification))
                                    .skills(Arrays.asList(javaSkill, springSkill, dotNetSkill)).build();

        Employee sirAziz = Employee.builder().firstName("Abdul").lastName("Aziz")
                                    .position(ceoPosition).build();

        employeeRepository.saveAll(Arrays.asList(taimoor, sirAziz));

        jbillingProject.setSupervisors(Arrays.asList(sirAziz));
        pliroProject.setSupervisors(Arrays.asList(sirAziz));

        projectRepository.saveAll(Arrays.asList(jbillingProject, pliroProject));
    }
}
