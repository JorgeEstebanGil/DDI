package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;

import com.example.biblioteca.model.LibroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Libro libro) {
        jdbcTemplate.update("insert into LIBRO(isbn, fecha_edicion, almacen_old, almacen_new) values (?,?,?,?);",
                libro.getIsbn(), libro.getFechaEdicion(), libro.getAlmacen_old(), libro.getAlmacen_new());
    }

    public void insert(Libro libro) {
        jdbcTemplate.update("insert into LIBRO(isbn, fecha_edicion, almacen_old, almacen_new) values (?,?,?,?);",
                libro.getIsbn(), libro.getFechaEdicion(), libro.getAlmacen_old(), libro.getAlmacen_new());
    }

    public void update(Libro libro) {
        jdbcTemplate.update("update LIBRO set isbn = ?, fecha_edicion = ?, almacen_old = ?, almacen_new = ? where id = ?;",
                libro.getIsbn(), libro.getFechaEdicion(), libro.getAlmacen_old(), libro.getAlmacen_new(), libro.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from LIBRO where id = ?;", id);
    }

    public List<Libro> findAll() {
        return jdbcTemplate.query("select * from LIBRO;", new LibroRowMapper());
    }

    public Libro findById(int id) {
        return jdbcTemplate.queryForObject("select * from LIBRO where id = ?;", new LibroRowMapper(), id);
    }

    public List<Libro> findByIsbn(String isbn) {
        return jdbcTemplate.query("select * from LIBRO where isbn = ?;", new LibroRowMapper(), isbn);
    }
}
