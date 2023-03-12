package niffler.api.client;

import niffler.models.Spend;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NifflerSpendClient {
    public static final String BASE_URL = "http://127.0.0.1:8093";
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

    private NifflerSpendService nifflerSpendService = retrofit.create(NifflerSpendService.class);
    public Spend createSpend(Spend spend) throws Exception {
        return nifflerSpendService.addSpend(spend).execute().body();
    }
}

