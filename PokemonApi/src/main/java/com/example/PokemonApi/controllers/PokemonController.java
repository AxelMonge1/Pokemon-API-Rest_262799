package com.example.PokemonApi.controllers;

import com.example.PokemonApi.models.Pokemon;
import com.example.PokemonApi.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pokemones")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> obtenerTodos(){
        return pokemonService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id);
    }

    @PostMapping
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.crearPokemon(pokemon);
    }

    @PostMapping("/{id}")
    public Pokemon actualizarCompleto(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return pokemonService.actualizarPokemonCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return pokemonService.actualizarPokemonParcial(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id){
        pokemonService.eliminarPokemon(id);
    }
}
