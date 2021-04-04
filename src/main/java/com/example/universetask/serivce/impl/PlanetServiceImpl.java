package com.example.universetask.serivce.impl;

import com.example.universetask.dao.PlanetsMapper;
import com.example.universetask.serivce.api.PlanetService;
import com.example.universetask.entity.Planet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanetServiceImpl implements PlanetService {
    private final PlanetsMapper planetsMapper;

    @Override
    public void destroy(int id) {
        planetsMapper.delete(id);
    }

    public Planet getPlanetByName(String name) {
        return planetsMapper.getPlanetByName(name);
    }

    @Override
    public List<Planet> getAvailable() {
        return planetsMapper.getAvailable();
    }

    @Override
    public Planet insert(Planet planet) {
        if (!planet.getName().equals("")) {
            planetsMapper.insert(planet);

        }
        return getPlanetByName(planet.getName());
    }
}
