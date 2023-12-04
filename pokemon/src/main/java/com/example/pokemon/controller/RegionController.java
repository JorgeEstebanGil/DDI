package com.example.pokemon.controller;

import com.example.pokemon.modelos.Region;
import com.example.pokemon.repositorio.RegionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private RegionRepositorio regionRepositorio;

    @RequestMapping("/listaRegion")
    public String listadoRegion(){
        return "listaRegion";
    }

    @RequestMapping("/formModificarRegion/{id}")
    public String formModificadoRegion(){
        return "formModificarRegion";
    }

    @RequestMapping("/formInsertarRegion")
    public String formInsertadoRegion(){
        return "formRegion";
    }

    @RequestMapping("/insertarRegion")
    public String insertarNuevoRegion(Region region){
        System.out.println(region.getId() + ", " + region.getNombre());
        regionRepositorio.crearRegion(region);
        return "listaRegion";
    }

    @RequestMapping("/actualizarRegion")
    public String actualizarRegion(Region region){
        System.out.println(region.getId() + ", " + region.getNombre());
        regionRepositorio.actualizarRegion(region);
        return "listaRegion";
    }

    @RequestMapping("/avisoEliminarRegion/{id}")
    public String avisoEliminarRegion(@PathVariable int id){
        Region region = regionRepositorio.getRegionPorId(id);
        if (region != null) {
            return "avisoEliminarRegion";
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/eliminarRegion/{id}")
    public String eliminarRegion(@PathVariable int id){
        Region region = regionRepositorio.getRegionPorId(id);
        if (region != null) {
            regionRepositorio.eliminarRegion(region);
            return "listaRegion";
        }
        else{
            return "paginaError";
        }
    }

    public List<Region> getTodosRegion(){
        return regionRepositorio.getTodosRegion();
    }

    public Region getRegionPorId(int id){
        return regionRepositorio.getRegionPorId(id);
    }
}
