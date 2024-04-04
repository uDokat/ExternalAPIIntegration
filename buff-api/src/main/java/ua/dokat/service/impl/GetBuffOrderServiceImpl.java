package ua.dokat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ua.dokat.entity.BuffOrder;
import ua.dokat.entity.BuffOrderList;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.service.GetBuffOrderService;
import ua.dokat.utils.RequestUtil;

import java.util.List;

@Service
public class GetBuffOrderServiceImpl implements GetBuffOrderService {


    //todo: заменить класс на WebClientUtils
    @Override
    public List<BuffOrder> sendRequest(String skinId, String pageSize) {

        try {

            WebClient.ResponseSpec responseSpec = RequestUtil.getResponseSpec(buildRequestUrl(skinId, pageSize));

            return responseSpec.bodyToMono(BuffOrderList.class).block().getData().getItems();

        }catch (WebClientResponseException e){

            BuffOrder buffOrder = new BuffOrder();
            buffOrder.setStatus(ResponseStatus.ERROR);
            return List.of(buffOrder);

        }

    }

    private String buildRequestUrl(String itemId, String pageSize) {
        return "/market/goods/sell_order?game=csgo&page_num=1&page_size=3&goods_id=" + itemId + "&sort_by=default";
    }
}
