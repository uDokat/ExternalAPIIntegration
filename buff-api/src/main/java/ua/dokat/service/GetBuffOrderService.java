package ua.dokat.service;

import ua.dokat.entity.BuffOrder;

import java.util.List;

public interface GetBuffOrderService {
    List<BuffOrder> sendRequest(String skinId, String pageSize);
}
