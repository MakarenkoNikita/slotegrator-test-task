package com.slotegrator.framework.api.retrofit;

import static com.slotegrator.framework.context.StaticContext.environmentConfiguration;

import com.slotegrator.framework.api.client.HttpClientBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitServiceBuilder {

  private OkHttpClient okHttpClient;
  private String baseUrl;

  public RetrofitServiceBuilder() {
    new RetrofitServiceBuilder(new HttpClientBuilder().getDefaultClient(), environmentConfiguration.getHost());
  }

  public RetrofitServiceBuilder(OkHttpClient okHttpClient, String baseUrl) {
    this.okHttpClient = okHttpClient;
    this.baseUrl = baseUrl;
  }

  public <T extends RetrofitServiceBuilder> T buildService(Class<T> serviceClass) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build();
    return retrofit.create(serviceClass);
  }
}
