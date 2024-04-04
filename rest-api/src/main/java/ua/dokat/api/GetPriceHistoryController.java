package ua.dokat.api;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dokat.entity.OrderPriceHistory;
import ua.dokat.service.impl.GetPriceHistoryServiceImpl;

import java.util.List;

@RestController
@Log4j
public class GetPriceHistoryController {


    private final GetPriceHistoryServiceImpl priceHistoryService;

    public GetPriceHistoryController(GetPriceHistoryServiceImpl priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }

    @PostMapping("/api/buff/price_history")
    public ResponseEntity<OrderPriceHistory> getPriceHistory(@RequestParam String skinId,
                                                             @RequestHeader String cookie, @RequestHeader(name = "X-CSRFToken") String token){

        OrderPriceHistory priceHistory = priceHistoryService.sendRequest(skinId, cookie, token);

        if (!priceHistory.isValid()) return ResponseEntity.status(HttpStatus.CONFLICT).body(priceHistory);

        return ResponseEntity.ok(priceHistory);
    }

}
