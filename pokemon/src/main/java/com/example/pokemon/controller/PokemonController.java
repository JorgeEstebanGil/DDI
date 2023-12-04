package com.example.pokemon.controller;

import com.example.pokemon.modelos.Pokemon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PokemonController {

    public String index() {
        return "index";
    }

    public void insertar() {


    }

    public void modificar() {


    }

    public void eliminar() {


    }

    public void listaPokemon(Model model) {
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);


    }

}
