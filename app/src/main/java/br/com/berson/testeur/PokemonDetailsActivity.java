package br.com.berson.testeur;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import br.com.berson.testeur.Adapters.PokemonsAdapter;
import br.com.berson.testeur.Controllers.ApiClient;
import br.com.berson.testeur.Models.Item;
import br.com.berson.testeur.Models.Pokedex;
import br.com.berson.testeur.Models.Pokemon;
import br.com.berson.testeur.Models.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailsActivity extends AppCompatActivity {
    private Result result;
    private String name;

    private TextView nomePokemon, alturatv, pesotv, xptv;

    private ImageView foto;


    private String peso, urlImagem;
    private String altura;
    private String xp;

    private ArrayList<Pokemon> caracteristicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pokemon_details);

        nomePokemon = findViewById(R.id.name);
        alturatv = findViewById(R.id.altura);
        pesotv = findViewById(R.id.peso);
        xptv = findViewById(R.id.xp);
        foto = findViewById(R.id.foto);

        result = (Result) getIntent().getSerializableExtra("op");
        name = result.getName();

        nomePokemon.setText(name);

        getPokemon();
    }


    private void getPokemon(){
        Call<Pokemon> call = ApiClient.acessar().choosePokemon(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                assert response.body() != null;
                altura = response.body().getHeight().toString();
                peso = response.body().getWeight().toString();
                xp = response.body().getBaseExperience().toString();

                urlImagem = response.body().getSprites().getFrontDefault();

                alturatv.setText(altura);
                pesotv.setText(peso);
                xptv.setText(xp);

                Glide.with(PokemonDetailsActivity.this)
                        .load(response.body().getSprites().getFrontDefault())
                        .into(foto);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }
}
