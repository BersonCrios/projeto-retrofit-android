package br.com.berson.testeur.Controllers;

        import android.util.Log;
        import com.google.gson.JsonObject;
        import java.util.concurrent.TimeUnit;

        import br.com.berson.testeur.Utils.Constants;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.logging.HttpLoggingInterceptor;
        import retrofit2.Call;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static Retrofit pokeApi = null;


    public static Retrofit getBlankApi() {
        OkHttpClient.Builder httpClient3 = new OkHttpClient.Builder();
        httpClient3.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClient3.readTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClient3.callTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClient3.writeTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClient3.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        pokeApi= new Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient3.build())
                .build();
        return pokeApi;
    }

    public static Retrofit getAdapter() {
        if (retrofit==null) {
            final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
            httpClient.readTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
            httpClient.callTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
            httpClient.writeTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);

            retrofit= new Retrofit.Builder()
                    .baseUrl(Constants.URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static AcessaPokemon acessar() {
        return getAdapter().create(AcessaPokemon.class);
    }


    public static AcessaPokemon acesso() {
        return getBlankApi().create(AcessaPokemon.class);
    }
}
