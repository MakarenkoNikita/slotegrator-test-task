package com.slotegrator.framework.api.client;

import static com.slotegrator.framework.context.StaticContext.environmentConfiguration;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.slotegrator.framework.api.interceptor.HttpClientInterceptorBuilder;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class HttpClientBuilder {

  private final Builder builder;

  public HttpClientBuilder() {
    this(new Builder());
  }

  public HttpClientBuilder(Builder builder) {
    this.builder = builder;
  }

  public OkHttpClient getDefaultClient() {
    return new HttpClientBuilder()
        .addConnectionTimeout(environmentConfiguration.getConnectionSecondTimeout())
        .addReadTimeout(environmentConfiguration.getReadSecondTimeout())
        .addWriteTimeout(environmentConfiguration.getWriteSecondTimeout())
        .addInterceptors(new HttpClientInterceptorBuilder().withDefaultInterceptors().getInterceptors())
        .build();
  }

  public HttpClientBuilder addConnectionTimeout(int timeout) {
    builder.connectTimeout(timeout, SECONDS);
    return this;
  }

  public HttpClientBuilder addReadTimeout(int timeout) {
    builder.readTimeout(timeout, SECONDS);
    return this;
  }

  public HttpClientBuilder addWriteTimeout(int timeout) {
    builder.writeTimeout(timeout, SECONDS);
    return this;
  }

  public HttpClientBuilder addInterceptors(List<Interceptor> interceptors) {
    interceptors.forEach(builder::addInterceptor);
    return this;
  }

  public OkHttpClient build() {
    return builder.build();
  }
}
