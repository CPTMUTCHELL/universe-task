package com.example.universetask;

import com.example.universetask.dao.PlanetsMapper;
import com.example.universetask.entity.Planet;
import com.example.universetask.serivce.impl.PlanetServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PlanetServiceTests {
    @Captor
    private ArgumentCaptor<Planet> argumentCaptor;

    private Planet p1;
    private Planet p2;
    private PlanetsMapper planetsMapper = Mockito.mock(PlanetsMapper.class);
    private PlanetServiceImpl service;
    @BeforeEach
    void setUp(){
        p1= new Planet();
        p2 = new Planet();
        p1.setId(1);
        p2.setId(2);
        p1.setName("Planet1");
        p2.setName("Planet2");
        service= new PlanetServiceImpl(planetsMapper);

    }
    @Test
    void shouldDeletePlanet(){
       service.destroy(p1.getId());
       Mockito.verify(planetsMapper,Mockito.times(1)).delete(p1.getId());
    }
    @Test
    void shouldFindPlanetByName(){
        Mockito.when(planetsMapper.getPlanetByName("Planet1")).thenReturn(p1);
        org.junit.jupiter.api.Assertions.assertEquals(planetsMapper.getPlanetByName("Planet1"),service.getPlanetByName("Planet1"));
    }
    @Test
    void shouldInsertPlanet(){
        service.insert(p1);
        Mockito.verify(planetsMapper, Mockito.times(1)).insert(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue().getName()).isEqualTo("Planet1");
    }

}
