package com.example.universetask.serivce.api;
import com.example.universetask.entity.Master;
import com.example.universetask.entity.Planet;

import java.util.List;

public interface MasterService {
   Master insert(Master master);

    List<Master> get10youngest();

    List<Master> getIdlers();
    Master getMasterByName(String name);
    List<Master> getAllMasters();

    List<Planet> getAllPlanetsByMasterId(int id);

    void addPlanetToMaster(int id, Planet planet);
}
