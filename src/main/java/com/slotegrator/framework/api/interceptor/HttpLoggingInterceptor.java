package com.slotegrator.framework.api.interceptor;

import static com.slotegrator.framework.execution.CustomLogger.getLogger;
import static okhttp3.ResponseBody.create;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class HttpLoggingInterceptor implements Interceptor {

  private final Logger log = getLogger();
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request();
    logRequestData(request);
    Response response = chain.proceed(request);
    String responseBodyAsString = response.body().string();
    logResponseData(response, responseBodyAsString);
    ResponseBody newResponseBody = create(responseBodyAsString, response.body().contentType());
    return response.newBuilder().body(newResponseBody).build();
  }

  private void logRequestData(Request request) throws IOException {
    log.info("\nREQUEST: [{}] {}", request.method(), request.url());
    if (request.body() != null) {
      Buffer buffer = new Buffer();
      request.body().writeTo(buffer);
      String body = parseJson(buffer.readUtf8());
      log.info("\nRequest body:\n{}", body);
    }
  }

  private void logResponseData(Response response, String responseBody) {
    log.info("""
        \nRESPONSE: [{}] {}
        Response status code: {}
        """, response.request().method(), response.request().url(), response.code());
    if (response.body() != null) {
      log.info("\nResponse body:\n{}", parseJson(responseBody));
    }
  }

  private String parseJson(String jsonStringValue) {
    try {
      JsonElement jsonElement = JsonParser.parseString(jsonStringValue);
      return gson.toJson(jsonElement);
    } catch (Exception e) {
      log.warn("Couldn't parse response body as JSON");
      return null;
    }
  }
}
