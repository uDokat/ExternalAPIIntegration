package ua.dokat.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ua.dokat.entity.OrderPriceHistory;
import ua.dokat.service.GetPriceHistoryService;
import ua.dokat.utils.RequestUtil;

@Service
@Log4j
public class GetPriceHistoryServiceImpl implements GetPriceHistoryService {

    //todo: заменить параметры куки и токенов в одну сущность Trader
    @Override
    public OrderPriceHistory sendRequest(String skinId, String cookie, String token) {

        try{

            WebClient.ResponseSpec responseSpec = RequestUtil.getResponseSpec(createUrl(skinId), cookie, token);
            return responseSpec.bodyToMono(OrderPriceHistory.class).block();

        }catch (WebClientResponseException e){
            throw e;
        }
    }

    private String createUrl(String skinId){
        return String.format("/market/goods/price_history/buff?game=csgo&goods_id=" + skinId + "&days=30&buff_price_type=1");
    }
}
