package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Entrenador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrenadorRowMapper implements RowMapper<Entrenador> {

    @Override
    public Entrenador mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Entrenador entrenador = new Entrenador(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getBoolean("active"));
        return entrenador;
    }
}
