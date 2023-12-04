package com.example.cerveza.Controllers;

import java.util.List;

import com.example.cerveza.Repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cerveza.Models.BeerModel;
import com.example.cerveza.Repositories.BreweryNewRepository;
import com.example.cerveza.Repositories.BreweryOldRepository;

@Controller
public class BeerController {
    @Autowired
    BreweryNewRepository breweryNewRepository;
    @Autowired
    BreweryOldRepository breweryOldRepository;

    @RequestMapping("/formBeer") //Si en el navegador ponemos localhost:8080/formBeer, nos lleva a la vista formBeer.html
    public String formBeer(Model model){
        model.addAttribute("nuevaBeer", new BeerModel()); //Creamos un objeto de tipo BeerModel y lo pasamos a la vista
        return "formBeer";
    }

    @RequestMapping("/insertarBeer") //Si en el navegador ponemos localhost:8080/insertarBeer, se ejecuta este método
    public String insertarBeer(BeerModel nuevaBeer, @RequestParam(name = "nueva", required = false, defaultValue = "false") boolean nueva) {

        if (nueva == true) { //Si hemos marcado el checkbox de nueva, quiere decir que es una nueva beer y se inserta en la tabla de beerNew
            BeerRepository.insertarBeer(nuevaBeer);
        }
        else { //Si no, quiere decir que es una beer antigua y se inserta en la tabla de beerOld
            //Creamos un objeto de tipo BeerOldModel porque por defecto en el formulario creamos un objeto de tipo BeerNewModel
            BeerModel beerOld = new BeerModel();
            beerOld.setNombre(nuevaBeer.getNombre());
            beerOld.setAnoLanzamiento(nuevaBeer.getAnoLanzamiento());
            beerOld.setCodigoBreweryNew(nuevaBeer.getCodigoBreweryNew());
            beerOld.setCodigoBreweryOld(nuevaBeer.getCodigoBreweryOld());
            BeerRepository.insertarBeer(beerOld);
        }
        return "index";
    }
}