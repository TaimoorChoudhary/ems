package io.auroraslutions.employManagementSystem.services.implementation;

import io.auroraslutions.employManagementSystem.domain.Position;
import io.auroraslutions.employManagementSystem.repositories.PositionRepository;
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
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Taimoor Choudhary on 9/14/18.
 */
class PositionServiceImpTest {

    @Mock
    PositionRepository positionRepository;

    @InjectMocks
    PositionServiceImp positionServiceImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {

        Position positionDeveloper = Position.builder().title("Developer").build();
        Position positionTeamLead = Position.builder().title("TeamLead").build();

        when(positionRepository.findAll()).thenReturn(Arrays.asList(positionDeveloper, positionTeamLead));

        List<Position> positionsFound = positionServiceImp.findAll();

        assertThat("All Positions not found", positionsFound.size(), is(2));
        verify(positionRepository, times(1)).findAll();
        verify(positionRepository, times(0)).findById(anyLong());
    }

    @Test
    void findById() {

        Position positionDeveloper = Position.builder().id(1L).title("Developer").build();
        Optional<Position> positionOptional = Optional.of(positionDeveloper);

        when(positionRepository.findById(1L)).thenReturn(positionOptional);

        Position positionFound = positionServiceImp.findById(1L);

        assertThat("Position not found", positionFound.getId(), is(positionDeveloper.getId()));
        verify(positionRepository, times(0)).findAll();
        verify(positionRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByTitle() {
        Position positionDeveloper = Position.builder().id(1L).title("Developer").build();

        when(positionRepository.findByTitle("Developer")).thenReturn(Optional.of(positionDeveloper));

        Position positionsFound = positionServiceImp.findByTitle("Developer");

        assertThat("Position list size mismatch", positionsFound, is(notNullValue()));
        assertThat("Position not found", positionsFound.getTitle(), is(positionDeveloper.getTitle()));
        verify(positionRepository, times(1)).findByTitle(anyString());
        verify(positionRepository, times(0)).findById(anyLong());
    }

    @Test
    void deleteById() {

        Long idToDelete = 3L;

        positionServiceImp.deleteById(idToDelete);

        verify(positionRepository, times(1)).deleteById(anyLong());
    }
}