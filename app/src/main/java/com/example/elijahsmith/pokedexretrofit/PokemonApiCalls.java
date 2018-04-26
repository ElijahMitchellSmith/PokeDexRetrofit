package com.example.elijahsmith.pokedexretrofit;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApiCalls {

    @GET("{name")
    Call<PokemonName> getPokemonName(@Path("name")String name);


    class PokemonName {
        @SerializedName("pokedex")
        private String pokedex;

        public String getPokedex() {
            return pokedex;
        }
    }
}
