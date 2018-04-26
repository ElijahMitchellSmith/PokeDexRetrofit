package com.example.elijahsmith.pokedexretrofit;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String POKEMON_NAME = "pokemon_name";
    public static final String POKEMON_ABILITY = "pokemon_ability";
    private PokemonFragment pokemonFragment;

    @BindView(R.id.pokemon_edittext)
    protected TextInputEditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.submit_button)
    protected void submitClicked() {
        pokemonFragment = PokemonFragment.newInstance();

        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Both Fields Are Required, Try Again!", Toast.LENGTH_LONG).show();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(POKEMON_NAME, name.getText().toString());
            pokemonFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, pokemonFragment).commit();

        }
    }
}
