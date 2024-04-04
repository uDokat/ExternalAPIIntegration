package ua.dokat.service.utils;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Log4j
public class RequestUtil {

    private static final String API_URL = "https://api.buff.market/api";

    public static WebClient.ResponseSpec getResponseSpec(String paramsUrl){
        WebClient client = WebClient.create(API_URL);

        //todo: вынести в конфиг
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", "Device-Id=r3xCiios2TsoXtQKrjat; forterToken=0eea571560ff48d9b781071530204eef_1707242263911__UDF43-m4_13ck_; ftr_ncd=6; fblo_881005522527906=y; session=1-aZUzFrnCkGhzAajVbaoI1Z6Q8YhRtjXkAuPv6QjTTuo82045652511; Locale-Supported=ru; csrf_token=IjY0Nzc3OGM2YWRmZTI3ZmRiMTZmYjlmMDQ5OTNlYWQwZmZlMzBiZGQi.GKQGYw.YGNST0F_QHEW3qD8Mh8mlX1Mi_g");
        headers.set("X-CSRFToken", "IjY0Nzc3OGM2YWRmZTI3ZmRiMTZmYjlmMDQ5OTNlYWQwZmZlMzBiZGQi.GKDjYg.3AazTNABGiUOjNrzbBwb5910Wb0");

        try{
            return client.get()
                    .uri(paramsUrl)
                    .headers(httpHeaders -> httpHeaders.putAll(headers))
                    .retrieve();
        }catch (WebClientResponseException e){
            log.error("status 429 or 500");
            return null;
        }
    }
}
