package com.example.universetask.dao;

import com.example.universetask.entity.Planet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlanetsMapper {
    @Insert("insert into planet (name) VALUES " +
            "(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    void insert(Planet entity);

    @Select("select * from planet where name=#{name}")
    Planet getPlanetByName(String name);
    @Select("SELECT * FROM planet WHERE id NOT IN (SELECT planet_id FROM master_planet) ")
    List<Planet> getAvailable();
    @Delete("delete from planet  where id=#{id}")
    void delete(int id);
}
