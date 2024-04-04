package ua.dokat.service;

import ua.dokat.entity.OrderPriceHistory;

public interface GetPriceHistoryService {

    OrderPriceHistory sendRequest(String skinId, String cookie, String token);
}
