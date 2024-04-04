package ua.dokat.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dokat.entity.BuffOrder;
import ua.dokat.entity.custom.CustomBuffOrder;
import ua.dokat.entity.custom.CustomBuffOrderList;
import ua.dokat.service.impl.GetBuffOrderServiceImpl;

import java.util.List;

@RestController
public class GetBuffOrderController {

    private final GetBuffOrderServiceImpl getBuffOrderService;

    public GetBuffOrderController(GetBuffOrderServiceImpl getBuffOrderService) {
        this.getBuffOrderService = getBuffOrderService;
    }

    @GetMapping("/api/buff/order")
    public ResponseEntity<CustomBuffOrderList> getBuffOrder(@RequestParam String skinId, @RequestParam String pageSize){
        List<BuffOrder> orders = getBuffOrderService.sendRequest(skinId, pageSize);

        if (orders.isEmpty() || !orders.get(0).isValid()) return ResponseEntity.status(HttpStatus.CONFLICT).body(CustomBuffOrderList.buildErrorResponse());

        List<CustomBuffOrder> customOrders = orders.stream().map(BuffOrder::toCustom).toList();
        return ResponseEntity.status(HttpStatus.OK).body(CustomBuffOrderList.builder().orders(customOrders).build());
    }
}
