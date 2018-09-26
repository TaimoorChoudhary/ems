package io.auroraslutions.employManagementSystem.repositories;

import io.auroraslutions.employManagementSystem.domain.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Taimoor Choudhary on 9/26/18.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PositionRepositoryTest {

    @Autowired
    PositionRepository positionRepository;

    @Test
    void findByTitle() {

        Optional<Position> developer = positionRepository.findByTitle("Developer");

        assertThat("Developer position not found", developer.get().getTitle(), is("Developer"));
    }
}