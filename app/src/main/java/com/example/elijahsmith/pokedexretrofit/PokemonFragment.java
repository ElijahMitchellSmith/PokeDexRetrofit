package com.example.elijahsmith.pokedexretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.elijahsmith.pokedexretrofit.MainActivity.POKEMON_NAME;

public class PokemonFragment extends Fragment {
    @BindView(R.id.summary_edit)
    protected TextView summary;
    private String baseUrl = "http://pokeapi.co/api/v2/pokemon/";
    private String spriteUrl = "http://pokeapi.co/media/sprites/pokemon/";
    private PokemonApiCalls pokemonApiCalls;
    private Retrofit retrofit;
    @BindView(R.id.pokemon_image)
    protected ImageView sprite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokedex, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private void buildRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonApiCalls = retrofit.create(PokemonApiCalls.class);

    }

    public static PokemonFragment newInstance() {

        Bundle args = new Bundle();

        PokemonFragment fragment = new PokemonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        String pokemonName = getArguments().getString(POKEMON_NAME);
        buildRetrofit();
        makeApiCall(pokemonName);
    }


    private void makeApiCall(String pokemonName) {
        pokemonApiCalls.getPokemonName(pokemonName).enqueue(new Callback<PokemonApiCalls.PokemonName>() {
            @Override
            public void onResponse(Call<PokemonApiCalls.PokemonName> call, Response<PokemonApiCalls.PokemonName> response) {
                if (response.isSuccessful()) {
                    summary.setText(response.body().getPokedex());

                    Glide.with(getContext()).load(spriteUrl).into(sprite);

                } else {
                    Toast.makeText(getContext(), "Complete the field", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PokemonApiCalls.PokemonName> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
