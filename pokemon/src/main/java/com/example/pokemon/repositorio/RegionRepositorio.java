package com.example.pokemon.repositorio;

import com.example.pokemon.modelos.Entrenador;
import com.example.pokemon.modelos.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Region> getTodosRegiones(){
        String query ="SELECT * FROM region;";
        List<Region> listaRegiones = jdbcTemplate.query(query, new RegionRowMapper());
        return listaRegiones;
    }

    public Region getRegionPorId(int id){
        String query = "SELECT * FROM region r WHERE r.id = ?";
        List<Region> listaRegion = jdbcTemplate.query(query, new RegionRowMapper(), id);
        return (listaRegion.isEmpty())? null: listaRegion.get(0);
    }

    public void eliminarRegion(Region region){
        //Borrar la region y todos sus  pokemon
        String query = "DELETE FROM pokemon WHERE region_id = ?";
        String query2 = "DELETE FROM region WHERE id = ?";
        jdbcTemplate.update(query, region.getId());
        jdbcTemplate.update(query2, region.getId());
    }

    public void actualizarRegion(Region region){
        String query = "UPDATE region SET nombre = ? WHERE id = ?";
        jdbcTemplate.update(query, region.getNombre(), region.getId());
    }

    public void crearRegion(Region region){
        String query = "INSERT INTO region (id, nombre) VALUES (?, ?)";
        jdbcTemplate.update(query, region.getId(), region.getNombre());
    }
}
