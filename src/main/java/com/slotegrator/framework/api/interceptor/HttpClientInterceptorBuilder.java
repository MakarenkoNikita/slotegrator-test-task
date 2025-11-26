package com.slotegrator.framework.api.interceptor;

import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;

@SuppressWarnings("unused")
public class HttpClientInterceptorBuilder {

  private final List<Interceptor> interceptors = new ArrayList<>();

  public HttpClientInterceptorBuilder withDefaultInterceptors() {
    return this.addStatusCodeInterceptor()
        .addLoggingInterceptor()
        .addRetryingInterceptor();
  }

  public HttpClientInterceptorBuilder addStatusCodeInterceptor() {
    interceptors.add(new HttpStatusCodeVerifyingInterceptor());
    return this;
  }

  public HttpClientInterceptorBuilder addLoggingInterceptor() {
    interceptors.add(new HttpLoggingInterceptor());
    return this;
  }

  public HttpClientInterceptorBuilder addRetryingInterceptor() {
    interceptors.add(new HttpClientRetryingInterceptor());
    return this;
  }

  public HttpClientInterceptorBuilder addInterceptor(Interceptor interceptor) {
    interceptors.add(interceptor);
    return this;
  }

  public List<Interceptor> getInterceptors() {
    return interceptors;
  }
}
