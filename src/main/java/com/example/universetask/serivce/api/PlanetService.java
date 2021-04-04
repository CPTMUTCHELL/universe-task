package com.example.universetask.serivce.api;

import com.example.universetask.entity.Planet;

import java.util.List;


public interface PlanetService {
    void destroy(int id);
    Planet insert(Planet planet);
    Planet getPlanetByName(String name);

    List<Planet> getAvailable();
}
