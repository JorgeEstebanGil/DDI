package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Pokemon> getTodosPokemon(){
        List<Pokemon> listaPokemon = jdbcTemplate.query(
                "SELECT * FROM pokemon",
                new PokemonRowMapper());
        return listaPokemon;
    }

    public Pokemon getPokemonPorId(int idPokemon){
        String query = "SELECT * FROM pokemon WHERE id = ?";
        List<Pokemon> listaPokemon = jdbcTemplate.query(query, new PokemonRowMapper(), idPokemon);
        return (listaPokemon.isEmpty())? null: listaPokemon.get(0);
    }

    public void eliminarPokemon(Pokemon pokemon){
        String query = "DELETE FROM pokemon WHERE id = ?";
        jdbcTemplate.update(query, pokemon.getId());
    }

    public void actualizarPokemon(Pokemon pokemon){
        String query = "UPDATE pokemon SET nombre = ?, region_id = ? WHERE id = ?";
        jdbcTemplate.update(query,
                pokemon.getNombre(), pokemon.getRegion_id(), pokemon.getId());
    }

    public void insertarPokemon(Pokemon pokemon){
        String query = "INSERT INTO pokemon (nombre, region_id) VALUES (?, ?, ?);";
        jdbcTemplate.update(query, pokemon.getNombre(), pokemon.getRegion_id());
    }
}
