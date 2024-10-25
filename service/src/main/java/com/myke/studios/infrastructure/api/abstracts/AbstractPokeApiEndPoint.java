package com.myke.studios.infrastructure.api.abstracts;

import com.myke.studios.abstracts.AbstractEndpoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Abstract class of api contact.
 */
@RequiredArgsConstructor
@Slf4j
public abstract class AbstractPokeApiEndPoint extends AbstractEndpoint {

  /**
   * RestTemplate.
   */
  private final RestTemplate restTemplate;

  /**
   * Get body response.
   * @param url .
   * @param httpMethod .
   * @param headers .
   * @param body .
   * @param responseType .
   * @param <T> .
   * @return Body of response.
   */
  protected <T> T doCall(final String url, final HttpMethod httpMethod,
                         HttpHeaders headers, final Object body, final Class<T> responseType) {
    return handleConnection(() -> {
      log.info("do call {}, method {}", url, httpMethod);
      return extractResponseData(restTemplate
          .exchange(new RequestEntity<>(body,headers,httpMethod,getUri(url)),
              responseType),responseType);
    });
  }
}
