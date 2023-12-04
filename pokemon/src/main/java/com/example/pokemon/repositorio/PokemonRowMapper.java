package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Pokemon;
import com.example.pokemon.modelos.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonRowMapper implements RowMapper<Pokemon> {

    @Override
    public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(rs.getInt("id"));

        Region region = new Region();
        pokemon.setRegion_id(rs.getInt("region_id"));
        return pokemon;
    }
}
