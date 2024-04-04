package ua.dokat.service;

import ua.dokat.entity.TraderInventory;

public interface GetInventoryBuff {
    TraderInventory sendRequest(Long pageNum, Long pageSize, String cookie, String token);
    String buildRequestUrl(Long pageNum, Long pageSize);
}
