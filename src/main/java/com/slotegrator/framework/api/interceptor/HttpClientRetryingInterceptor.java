package com.slotegrator.framework.api.interceptor;

import static com.slotegrator.framework.execution.CustomLogger.getLogger;
import static com.slotegrator.framework.waiter.Waiter.waitSeconds;

import java.io.IOException;
import java.util.Set;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class HttpClientRetryingInterceptor implements Interceptor {

  private int maxApiCallAttempts;
  private int waitTimeoutBetweenApiCallsInSecond;
  private final Set<Integer> expectedCodesForRetry = Set.of(400, 500);
  private final Logger log = getLogger();

  HttpClientRetryingInterceptor() {
    new HttpClientRetryingInterceptor(3, 1);
  }

  HttpClientRetryingInterceptor(int maxApiCallAttempts, int waitTimeoutBetweenApiCallsInSecond) {
    this.maxApiCallAttempts = maxApiCallAttempts;
    this.waitTimeoutBetweenApiCallsInSecond = waitTimeoutBetweenApiCallsInSecond;
  }

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    for (int apiCallAttempt = 0; apiCallAttempt < maxApiCallAttempts; apiCallAttempt++) {
      response = chain.proceed(chain.request());
      if (expectedCodesForRetry.contains(response.code())) {
        log.error("Failed [{}] attempt to send request to: [{}]. Response code is [{}]",
            apiCallAttempt, chain.request().url(), response.code()
        );
      }
      waitSeconds(waitTimeoutBetweenApiCallsInSecond);
    }
    return response;
  }
}
