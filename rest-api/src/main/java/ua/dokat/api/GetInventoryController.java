package ua.dokat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dokat.entity.TraderInventory;
import ua.dokat.entity.custom.CustomTraderInventory;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.service.impl.GetInventoryBuffService;

@RestController
public class GetInventoryController {

    private final GetInventoryBuffService getInventoryBuffService;

    public GetInventoryController(GetInventoryBuffService getInventoryBuffService) {
        this.getInventoryBuffService = getInventoryBuffService;
    }

    @GetMapping("/api/buff/inventory")
    public CustomTraderInventory getInventory(@RequestParam Long pageNum, @RequestParam Long pageSize,
                                              @RequestHeader("Cookie") String cookie, @RequestHeader("X-CSRFToken") String token){
        TraderInventory traderInventory = getInventoryBuffService.sendRequest(pageNum, pageSize, cookie, token);

        if (!traderInventory.isValid()) return CustomTraderInventory.builder().status(ResponseStatus.ERROR).build();

        return traderInventory.toCustom();
    }
}
