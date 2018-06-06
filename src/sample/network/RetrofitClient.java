package sample.network;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class RetrofitClient {
    public static String baseURL = "http://localhost:8080/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        return retrofit;
    }

    public static Retrofit setClient(final String myToken)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        if(!myToken.equals(""))
        {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", myToken); // <-- this is the important line

                    System.out.println(myToken);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

            OkHttpClient client2 = httpClient.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(client2)
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .build();

        }
        else {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
//                    .client(new OkHttpClient())
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .build();
        }

        return retrofit;
    }

}
