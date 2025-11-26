package com.slotegrator.framework.api.interceptor;

import static java.lang.String.format;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class HttpStatusCodeVerifyingInterceptor implements Interceptor {

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    if (!response.isSuccessful()) {
      throw new IllegalStateException(format("""
          Not valid HTTP status code [%d]
          Request url [%s]
          """, response.code(), response.request().url()));
    }
    return response;
  }
}
