package ua.dokat.utils;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Log4j
public class RequestUtil {

    private static final String API_URL = "https://api.buff.market/api";

    public static WebClient.ResponseSpec getResponseSpec(String paramsUrl, String cookie, String token){
        WebClient client = WebClient.create(API_URL);

        try{

            return client.get()
                    .uri(paramsUrl)
                    .headers(httpHeaders -> httpHeaders.putAll(createHeaders(cookie, token)))
                    .retrieve();

        }catch (WebClientResponseException e){

            log.error("status 429 or 500: " + e.getMessage());
            throw e;

        }
    }

    public static WebClient.ResponseSpec getResponseSpec(String paramsUrl){
        WebClient client = WebClient.create(API_URL);

        try{

            return client.get()
                    .uri(paramsUrl)
                    .retrieve();

        }catch (WebClientResponseException e){

            log.error("status 429 or 500: " + e.getMessage());
            throw e;

        }
    }

    private static HttpHeaders createHeaders(String cookie, String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);
        headers.set("X-CSRFToken", token);
        return headers;
    }
}
