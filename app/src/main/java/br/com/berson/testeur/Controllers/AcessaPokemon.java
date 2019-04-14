package br.com.berson.testeur.Controllers;

import com.google.gson.JsonObject;

import br.com.berson.testeur.Models.HeldItem;
import br.com.berson.testeur.Models.Item;
import br.com.berson.testeur.Models.Pokedex;
import br.com.berson.testeur.Models.Pokemon;
import br.com.berson.testeur.Models.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AcessaPokemon {
    @GET("pokemon/")
    Call<Pokedex> getPokemons();

    @GET("pokemon/{nome}")
    Call<Pokemon> choosePokemon (@Path("nome") String nome);
}
