package com.slotegrator.framework.api.retrofit;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.slotegrator.framework.context.constant.StaticContext.environmentConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slotegrator.framework.api.client.HttpClientBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitServiceBuilder {

  private final OkHttpClient okHttpClient;
  private final String baseUrl;
  private final ObjectMapper objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, true);

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
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .client(okHttpClient)
        .build();
    return retrofit.create(serviceClass);
  }
}
