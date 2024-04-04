package ua.dokat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dokat.entity.Goods;
import ua.dokat.entity.custom.CustomGoods;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.service.impl.GetItemBuffService;

@RestController
public class GetItemController {

    private final GetItemBuffService getItemBuffService;

    public GetItemController(GetItemBuffService getItemBuffService) {
        this.getItemBuffService = getItemBuffService;
    }

    @GetMapping("/api/buff/user/item")
    public CustomGoods getItemFromUser(@RequestParam Long itemId,
                               @RequestHeader("Cookie") String cookie, @RequestHeader("X-CSRFToken") String token){
        Goods goods = getItemBuffService.sendRequest(itemId, cookie, token);

        if (!goods.isValid()) return CustomGoods.builder().status(ResponseStatus.ERROR).build();

        return goods.toCustom();
    }

    @GetMapping("/api/buff/item")
    public CustomGoods getItem(@RequestParam Long itemId){
        Goods goods = getItemBuffService.sendRequest(itemId);

        if (!goods.isValid()) return CustomGoods.builder().status(ResponseStatus.ERROR).build();

        return goods.toCustom();
    }
}
