package com.example.elijahsmith.pokedexretrofit;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApiCalls {

    @GET("{pokemon}")
    Call<PokemonName> getPokemonName(@Path("pokemon")String pokemonName);


    class PokemonName {
        @SerializedName("pokedex")
        private String pokedex;

        public String getPokedex() {
            return pokedex;
        }
    }
}
