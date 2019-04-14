package br.com.berson.testeur;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import br.com.berson.testeur.Adapters.PokemonsAdapter;
import br.com.berson.testeur.Controllers.ApiClient;
import br.com.berson.testeur.Models.HeldItem;
import br.com.berson.testeur.Models.Item;
import br.com.berson.testeur.Models.Pokedex;
import br.com.berson.testeur.Models.Pokemon;
import br.com.berson.testeur.Models.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rescPoke;
    private ArrayList<Result> pokemonsList = new ArrayList<>();
    private PokemonsAdapter adapterPokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rescPoke = findViewById(R.id.pokemons);

        getPokemons();
    }


    private void getPokemons(){
        Call<Pokedex> call = ApiClient.acessar().getPokemons();
        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(@NonNull Call<Pokedex> call, @NonNull Response<Pokedex> response) {
                assert response.body() != null;
                pokemonsList.addAll(response.body().getResults());

                Log.e("dee", response.body().getResults().toString());
                adapterPokemons = new PokemonsAdapter(MainActivity.this, pokemonsList, item -> {
                    Log.e("Pokemon CLicado", item.getName());
                    Intent intent = new Intent(MainActivity.this, PokemonDetailsActivity.class);
                    intent.putExtra("op", item);
                    startActivity(intent);
                });

                rescPoke.setAdapter(adapterPokemons);
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {

            }
        });
    }
}
