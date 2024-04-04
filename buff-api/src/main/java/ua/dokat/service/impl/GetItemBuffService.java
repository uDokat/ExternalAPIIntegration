package ua.dokat.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ua.dokat.service.GetItemBuff;
import ua.dokat.entity.Goods;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.utils.RequestUtil;

@Service
@Log4j
public class GetItemBuffService implements GetItemBuff {

    @Override
    public Goods sendRequest(Long itemId, String cookie, String token) {

        try {

            WebClient.ResponseSpec response = RequestUtil.getResponseSpec(buildRequestUrl(itemId), cookie, token);
            return response.bodyToMono(Goods.class).block();

        }catch (WebClientResponseException e){

            Goods goods = new Goods();
            goods.setStatus(ResponseStatus.ERROR);
            return goods;

        }
    }

    //todo: закинуть в интерфейс и перегрузки не должно быть
    public Goods sendRequest(Long itemId) {

        try {

            WebClient.ResponseSpec response = RequestUtil.getResponseSpec(buildRequestUrl(itemId));
            return response.bodyToMono(Goods.class).block();

        }catch (WebClientResponseException e){

            Goods goods = new Goods();
            goods.setStatus(ResponseStatus.ERROR);
            return goods;

        }
    }

    private String buildRequestUrl(Long itemId) {
        return String.format("/market/goods/info?game=csgo&goods_id=%d", itemId);
    }
}
