package com.rtukpe.fixtures.data.repository.remote.helpers.base;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.rtukpe.fixtures.utils.others.AppUtils.gson;

/**
 * Created by rtukpe on 14/03/2018.
 */

public class BaseHelper {
    private OkHttpClient.Builder okHttpCBuilder = new OkHttpClient.Builder();

    private Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static String getBaseUrl() {
//        return "http://10.0.2.2:3000/api/";
        return "https://ouida-web.herokuapp.com/api/";
    }

    public <S> S createService(Class<S> serviceClass) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpCBuilder.networkInterceptors().add(httpLoggingInterceptor);
        okHttpCBuilder.retryOnConnectionFailure(true);
        OkHttpClient client = okHttpCBuilder.build();

        builder.client(client);
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}
