package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class EntrenadorRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Entrenador> getTodosEntrenadores(){
        String query = "SELECT * FROM entrenador;";
        return jdbcTemplate.query(query, new EntrenadorRowMapper());
    }

    public Entrenador getEntrenadorPorId(int id){
        String query = "SELECT * FROM entrenador WHERE id = ?";
        List<Entrenador> listaEntrenadores = jdbcTemplate.query(query, new EntrenadorRowMapper(), id);
        return (listaEntrenadores.isEmpty())? null: listaEntrenadores.get(0);
    }

    public void eliminarEntrenador(Entrenador entrenador){
        String query = "DELETE FROM entrenador WHERE id = ?;\n";
        jdbcTemplate.update(query, entrenador.getId());
    }

    public void actualizarEntrenador(Entrenador entrenador){
        String query = "UPDATE entrenador SET nombre = ?, active = ? WHERE id = ?";
        jdbcTemplate.update(query, entrenador.getNombre(), entrenador.isActive(), entrenador.getId());
    }

    public void crearEntrenador(Entrenador entrenador){
        String query = "INSERT INTO entrenador (nombre, active) VALUES (?, ?)";
        jdbcTemplate.update(query, entrenador.getNombre(), entrenador.isActive());
    }

}
