package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.Config;

public class ApiClient {
    private static ApiEndpoints apiService;

    public static ApiEndpoints getApiService() {
        if (apiService == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Gson gson = new GsonBuilder()
                    .setLenient() // Enable lenient parsing
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create(gson)) // Use the custom Gson instance
                    .client(httpClient.build())
                    .build();

            apiService = retrofit.create(ApiEndpoints.class);
        }
        return apiService;
    }
}
