package com.example.elijahsmith.pokedexretrofit;

import android.support.v4.app.Fragment;

import retrofit2.Retrofit;

public class PokemonFragment extends Fragment {
    private String baseUrl = "http://pokeapi.co/api/v2/";
    private PokemonApiCalls pokemonApiCalls;
    private Retrofit retrofit;
}
