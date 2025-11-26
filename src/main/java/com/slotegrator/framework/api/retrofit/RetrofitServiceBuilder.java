package com.slotegrator.framework.api.retrofit;

import static com.slotegrator.framework.context.constant.StaticContext.environmentConfiguration;

import com.google.gson.GsonBuilder;
import com.slotegrator.framework.api.client.HttpClientBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceBuilder {

  private final OkHttpClient okHttpClient;
  private final String baseUrl;

  public RetrofitServiceBuilder() {
    this(new HttpClientBuilder().getDefaultClient(), environmentConfiguration.getBaseUrl());
  }

  public RetrofitServiceBuilder(OkHttpClient okHttpClient, String baseUrl) {
    this.okHttpClient = okHttpClient;
    this.baseUrl = baseUrl;
  }

  public <T extends RetrofitService> T buildService(Class<T> serviceClass) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
        .client(okHttpClient)
        .build();
    return retrofit.create(serviceClass);
  }
}
