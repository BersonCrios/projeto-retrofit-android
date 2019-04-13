package br.com.berson.testeur.Controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AcessaPokemon {
    @GET("pokemon/ditto")
    Call<JsonObject> getDitto();
}
