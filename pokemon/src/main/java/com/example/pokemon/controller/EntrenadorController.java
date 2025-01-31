package com.example.pokemon.controller;

import com.example.pokemon.modelos.Entrenador;
import com.example.pokemon.repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EntrenadorController {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @RequestMapping("/listaEntrenadores")
    public String listadoEntrenadores(Model model){
        List<Entrenador> listaEntrenadores = entrenadorRepositorio.getTodosEntrenadores();
        model.addAttribute("listaEntrenadores", listaEntrenadores);
        return "listaEntrenadores";
    }

    @RequestMapping("/formModificarEntrenador/{id}")
    public String formModificadoEntrenador(int id, Model model){
        Entrenador entrenador = entrenadorRepositorio.getEntrenadorPorId(id);
        if (entrenador != null) {
            model.addAttribute("entrenador", entrenador);
            return "formModificarEntrenador";
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/formInsertarEntrenador")
    public String formInsertadoEntrenador(Model model){
        Entrenador entrenador = new Entrenador();
        model.addAttribute("entrenador", entrenador);
        return "formEntrenador";
    }

    @RequestMapping("/insertarEntrenador")
    public String insertarNuevoEntrenador(Entrenador entrenador, Model model){
        System.out.println(entrenador.getId() + ", " + entrenador.getNombre());
        entrenadorRepositorio.crearEntrenador(entrenador);
        return listadoEntrenadores(model);
    }

    @RequestMapping("/actualizarEntrenador")
    public String actualizarEntrenador(Entrenador entrenador, Model model){
        System.out.println(entrenador.getId() + ", " + entrenador.getNombre());
        entrenadorRepositorio.actualizarEntrenador(entrenador);
        return listadoEntrenadores(model);
    }

    @RequestMapping("/avisoEliminarEntrenador/{id}")
    public String avisoEliminarEntrenador(int id, Model model){
        Entrenador entrenador = entrenadorRepositorio.getEntrenadorPorId(id);
        if (entrenador != null) {
            model.addAttribute("entrenador", entrenador);
            return "avisoEliminarEntrenador";
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/eliminarEntrenador/{id}")
    public String eliminarEntrenador(int id, Model model){
        Entrenador entrenador = entrenadorRepositorio.getEntrenadorPorId(id);
        if (entrenador != null) {
            entrenadorRepositorio.eliminarEntrenador(entrenador);
            return listadoEntrenadores(model);
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/hacerActivoEntrenador/{id}")
    //al hacer activo debe poner el resto a inactivo
    public String hacerActivoEntrenador(int id, Model model){
        Entrenador entrenador = entrenadorRepositorio.getEntrenadorPorId(id);
        if (entrenador != null) {
            entrenadorRepositorio.hacerActivoEntrenador(entrenador);
            return listadoEntrenadores(model);
        }
        else{
            entrenadorRepositorio.hacerInactivoEntrenador(entrenador);
            return listadoEntrenadores(model);
        }
    }

    public List<Entrenador> getTodosEntrenadores(){
        return entrenadorRepositorio.getTodosEntrenadores();
    }

    public Entrenador getEntrenadorPorId(int id){
        return entrenadorRepositorio.getEntrenadorPorId(id);
    }
}
