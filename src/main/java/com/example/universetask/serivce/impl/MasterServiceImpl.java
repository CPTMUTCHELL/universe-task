package com.example.universetask.serivce.impl;

import com.example.universetask.dao.MastersMapper;
import com.example.universetask.entity.Planet;
import com.example.universetask.serivce.api.MasterService;
import com.example.universetask.entity.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {
    private final MastersMapper mastersMapper;
    @Override
    public Master insert(Master master) {
        if (master.getAge() > 0 && !master.getName().equals("")) {
            mastersMapper.insert(master);

        }
        return getMasterByName(master.getName());
    }

    @Override
    public List<Master> get10youngest() {
        return mastersMapper.getTop10();
    }

    @Override
    public List<Master> getIdlers() {
        return mastersMapper.getIdlers();
    }

    @Override
    public Master getMasterByName(String name) {
        return mastersMapper.getMasterByName(name);
    }

    @Override
    public List<Master> getAllMasters() {
        return mastersMapper.getAllMasters();
    }

    @Override
    public List<Planet> getAllPlanetsByMasterId(int id) {
        return mastersMapper.getPlanetsByMasterId(id);
    }

    @Override
    public void addPlanetToMaster(int id, Planet planet) {

        mastersMapper.addPlanetToMaster(id, planet.getId());
    }
}
