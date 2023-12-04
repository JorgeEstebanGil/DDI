package com.example.pokemon.controller;

import java.util.List;

import com.example.pokemon.modelos.Pokemon;
import com.example.pokemon.modelos.Region;
import com.example.pokemon.repositorio.PokemonRepositorio;
import com.example.pokemon.repositorio.PokemonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {

    @Autowired
    private PokemonRepositorio pokemonRepositorio;

    @Autowired
    private RegionController regionController;

    @RequestMapping("/listaPokemon")
    public String listaPokemon(Model model){
        List<Pokemon> listaPokemon = pokemonRepositorio.getTodosPokemon();
        model.addAttribute("listaPokemon", listaPokemon);
        return "listaPokemon";
    }

    @RequestMapping("/formPokemon")
    public String formInsertarPokemon(Model model){
        Pokemon pokemon = new Pokemon();
        model.addAttribute("nuevoPokemon", pokemon);
        model.addAttribute("listaRegiones", regionController.getTodasRegiones());
        return "formPokemon";
    }

    @RequestMapping("/insertarPokemon")
    public String insertarPokemon(Pokemon pokemon, @RequestParam String idRegion, Model model){
        Region region = regionController.getRegionPorId(Integer.parseInt(idRegion));
        pokemon.setRegion(region);
        pokemonRepositorio.insertarPokemon(pokemon);
        return listaPokemon(model);
    }

    @RequestMapping("/formModificarPokemon/{id}")
    public String formModificarPokemon(Model model, @PathVariable String id){
        Pokemon pokemon = pokemonRepositorio.getPokemonPorId(Integer.parseInt(id));
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("listaRegiones", regionController.getTodasRegiones());
        return "formModificarPokemon";
    }

    @RequestMapping("/actualizarPokemon")
    public String actualizarPokemon(Pokemon pokemon, @RequestParam String idRegion, Model model){
        Region region = regionController.getRegionPorId(Integer.parseInt(idRegion));
        pokemon.setRegion(region);
        pokemonRepositorio.actualizarPokemon(pokemon);
        return listaPokemon(model);
    }

    @RequestMapping("/eliminarPokemon/{id}")
    public String eliminarPokemon(@PathVariable String id, Model model){
        Pokemon pokemon = pokemonRepositorio.getPokemonPorId(Integer.parseInt(id));
        pokemonRepositorio.eliminarPokemon(pokemon);
        return listaPokemon(model);
    }

}
