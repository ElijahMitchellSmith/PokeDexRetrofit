package com.example.elijahsmith.pokedexretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApiCalls {

    @GET("{pokemon}")
    Call<PokemonName> getPokemonName(@Path("pokemon") String pokemonName);


    class PokemonName {
        @SerializedName("species")
        private List<name> namesList;
        @SerializedName("pokedex")
        private String pokedex;

        @SerializedName("sprites")
        private PokemonImage pokemonImage;

        @SerializedName("abilities")
        private List<Abilities> abilitiesList;

        public List<Abilities> getAbilitiesList() {
            return abilitiesList;
        }

        public PokemonImage getPokemonImage() {
            return pokemonImage;
        }

        public List<name> getNamesList() {
            return namesList;
        }

        public String getPokedex() {
            return pokedex;
        }

        class Abilities {
            @SerializedName("ability")
            private Ability ability;

            public Ability getAbility() {
                return ability;
            }

            class Ability {
                @SerializedName("name")
                private String name;

                public String getName() {
                    return name;
                }
            }
        }

        class PokemonImage {
            @SerializedName("front_default")
            private String imageUrl;


            public String getImageUrl() {
                return imageUrl;
            }

        }
        class name {
            @SerializedName("name")
            private String speciesName;

            public String getSpeciesName() {
                return speciesName;
            }
        }
    }
}

