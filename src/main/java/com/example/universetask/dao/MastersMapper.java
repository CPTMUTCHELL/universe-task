package com.example.universetask.dao;

import com.example.universetask.entity.Master;
import com.example.universetask.entity.Planet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MastersMapper {
    @Insert("insert into master (name,age) VALUES " +
            "(#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Master master);

    @Select("select * from master where name=#{name}")
    Master getMasterByName(String name);
    @Select("select * from master")
    List<Master> getAllMasters();
    @Select("select * from planet inner join master_planet mp on planet.id = mp.planet_id where mp.master_id=#{id}")
    List<Planet> getPlanetsByMasterId(int id);
    @Select("select * from master WHERE id NOT IN (SELECT master_id FROM master_planet)")
    List<Master> getIdlers();

    @Update("insert into master_planet ( master_id,planet_id) values ( #{id}, #{planetId})")
    void addPlanetToMaster(int id, int planetId);
    @Select("select * from master order by age asc limit 10")
    List<Master> getTop10();
}
