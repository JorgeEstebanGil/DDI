package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Pokemon;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonRowMapper implements RowMapper<Pokemon> {

    @Override
    public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(rs.getInt("id"));
        pokemon.setNombre(rs.getString("nombre"));
        pokemon.setRegion(rs.getString("region"));
        return pokemon;
    }
}
