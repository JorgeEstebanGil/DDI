package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Region;
import org.springframework.jdbc.core.RowMapper;

public class RegionRowMapper implements RowMapper<Region> {

    @Override
    public Region mapRow(java.sql.ResultSet resultSet, int rowNum) throws java.sql.SQLException {
        Region region = new Region(resultSet.getInt("id"), resultSet.getString("nombre"));
        return region;
    }
}
