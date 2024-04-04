package ua.dokat.service;

import ua.dokat.entity.Goods;

public interface GetItemBuff {
    Goods sendRequest(Long itemId, String cookie, String token);
}
