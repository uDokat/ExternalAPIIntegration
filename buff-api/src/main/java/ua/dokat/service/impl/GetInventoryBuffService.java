package ua.dokat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ua.dokat.entity.TraderInventory;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.service.GetInventoryBuff;
import ua.dokat.utils.RequestUtil;

@Service
public class GetInventoryBuffService implements GetInventoryBuff {

    @Override
    public TraderInventory sendRequest(Long pageNum, Long pageSize, String cookie, String token) {

        try {

            WebClient.ResponseSpec response = RequestUtil.getResponseSpec(buildRequestUrl(pageNum, pageSize), cookie, token);
            return response.bodyToMono(TraderInventory.class).block();

        }catch (WebClientResponseException e){

            TraderInventory inventory = new TraderInventory();
            inventory.setStatus(ResponseStatus.ERROR);
            return inventory;

        }
    }

    @Override
    public String buildRequestUrl(Long pageNum, Long pageSize) {
        return String.format("/market/steam_inventory?game=csgo&page_num=%d&page_size=%d", pageNum, pageSize);
    }
}
